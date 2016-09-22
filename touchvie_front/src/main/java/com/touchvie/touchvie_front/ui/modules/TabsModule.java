package com.touchvie.touchvie_front.ui.modules;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.builders.Target;
import com.touchvie.touchvie_front.ui.adapters.TabsModuleAdapter;
import com.touchvie.touchvie_front.ui.fragments.Section;
import com.touchvie.touchvie_front.ui.listeners.CardDetailListener;
import com.touchvie.touchvie_front.ui.views.AutoHeightViewPager;
import com.touchvie.touchvie_front.ui.views.Module;

import java.util.ArrayList;

/**
 * Created by Tagsonomy S.L. on 16/09/2016.
 */
public class TabsModule extends Module {

    private AutoHeightViewPager mViewPager;
    private TabLayout mTabLayout;
    private ArrayList<Section> sectionList;
    private ArrayList<String> sectionNames;
    private int pageSelected = 0;

    /**
     * Default constructor
     */
    public TabsModule(View v) {
        super(v);
        mViewPager = (AutoHeightViewPager) v.findViewById(R.id.module_tabs_viewpager);
        mTabLayout = (TabLayout) v.findViewById(R.id.module_tabs_tablayout);
        sectionList = new ArrayList<>();
        sectionNames = new ArrayList<>();
        System.out.println("KKKKK TabsModule builder");
    }

    private AutoHeightViewPager getViewPager() {
        return mViewPager;
    }

    public void setViewPager(AutoHeightViewPager mViewPager) {
        this.mViewPager = mViewPager;
    }

    private TabLayout getTabLayout() {
        return mTabLayout;
    }

    public void setTabLayout(TabLayout mTabLayout) {
        this.mTabLayout = mTabLayout;
    }

    public void configure(Context context, final TabsModule relatedMoviesVH, final Target[] target, final CardDetailListener mListener) {
        System.out.println("KKKKK TabsModule configure");
        if (relatedMoviesVH.getViewPager().getAdapter() == null) {
            if (target != null && target.length > 0) {
                sectionList = new ArrayList<>();
                sectionNames = new ArrayList<>();

                System.out.println("KKKKK TabsModule currentItem " + relatedMoviesVH.getViewPager().getCurrentItem());
                //relatedMoviesVH.getViewPager().reMeasureCurrentPage(relatedMoviesVH.getViewPager().getCurrentItem());

                for (Target aTarget : target) {
                    sectionList.add(mListener.requestSectionForTab(aTarget.getSectionId()));
                    sectionNames.add(mListener.requestSectionTitleForTab(aTarget.getSectionId()));
                }
                if (sectionList.size() > 0) {
                    TabsModuleAdapter tabsModuleAdapter = new TabsModuleAdapter(mListener.requestFragmentManager(), sectionList, sectionNames);
                    relatedMoviesVH.getViewPager().setAdapter(tabsModuleAdapter);
                    relatedMoviesVH.getViewPager().addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                        @Override
                        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                        }

                        @Override
                        public void onPageSelected(int position) {
                            pageSelected = position;
                            System.out.println("KKKKKKK onPageSelected " + pageSelected);
                            relatedMoviesVH.getViewPager().reMeasureCurrentPage(pageSelected);
                        }

                        @Override
                        public void onPageScrollStateChanged(int state) {

                        }
                    });

                    for (int i = 0; i < tabsModuleAdapter.getCount(); i++) {
                        relatedMoviesVH.getTabLayout().addTab(relatedMoviesVH.getTabLayout().newTab().setText(tabsModuleAdapter.getPageTitle(i)));
                    }

                    relatedMoviesVH.getTabLayout().setupWithViewPager(relatedMoviesVH.getViewPager());
                }
            }
        }
        else{
            System.out.println("KKKKKKKKKKK no nulo");
        }
    }
}
