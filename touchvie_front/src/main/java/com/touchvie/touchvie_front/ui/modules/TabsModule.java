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

    /**
     * Default constructor
     */
    public TabsModule(View v) {
        super(v);
        mViewPager = (AutoHeightViewPager) v.findViewById(R.id.module_tabs_viewpager);
        mTabLayout = (TabLayout) v.findViewById(R.id.module_tabs_tablayout);
        sectionList = new ArrayList<>();
        sectionNames = new ArrayList<>();
    }

    public AutoHeightViewPager getViewPager() {
        return mViewPager;
    }

    public void setViewPager(AutoHeightViewPager mViewPager) {
        this.mViewPager = mViewPager;
    }

    public TabLayout getTabLayout() {
        return mTabLayout;
    }

    public void setTabLayout(TabLayout mTabLayout) {
        this.mTabLayout = mTabLayout;
    }

    public void configure(Context context, final TabsModule relatedMoviesVH, final Target[] target, final CardDetailListener mListener) {
        System.out.println("KKKKKKKKKKKKKK TabsModule ");
        if (target != null && target.length > 0) {
            sectionList = new ArrayList<>();
            sectionNames = new ArrayList<>();
            for (int i = 0; i < target.length; i++) {
                sectionList.add(mListener.requestSectionForTab(target[i].getSectionId()));
                sectionNames.add(mListener.requestSectionTitleForTab(target[i].getSectionId()));
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
                        relatedMoviesVH.getViewPager().reMeasureCurrentPage(relatedMoviesVH.getViewPager().getCurrentItem());
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                });

                for (int i = 0; i < tabsModuleAdapter.getCount(); i++) {
                    relatedMoviesVH.getTabLayout().addTab(relatedMoviesVH.getTabLayout().newTab().setText(tabsModuleAdapter.getPageTitle(i)));
                }

//                relatedMoviesVH.getViewPager().addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(relatedMoviesVH.getTabLayout()));
                relatedMoviesVH.getTabLayout().setupWithViewPager(relatedMoviesVH.getViewPager());
            }
        }
    }
}
