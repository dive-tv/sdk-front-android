package com.touchvie.touchvie_front.ui.modules;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.builders.Target;
import com.touchvie.touchvie_front.ui.adapters.TabsModuleAdapter;
import com.touchvie.touchvie_front.ui.fragments.Section;
import com.touchvie.touchvie_front.ui.listeners.CardDetailListener;
import com.touchvie.touchvie_front.ui.views.Module;

import java.util.ArrayList;

/**
 * Created by Tagsonomy S.L. on 16/09/2016.
 */
public class TabsModule extends Module {

    private ViewPager mViewPager;
    private ArrayList<Section> sectionList;

    /**
     * Default constructor
     */
    public TabsModule(View v) {
        super(v);
        mViewPager = (ViewPager) v.findViewById(R.id.module_tabs_viewpager);
        sectionList = new ArrayList<>();
    }

    public ViewPager getmViewPager() {
        return mViewPager;
    }

    public void setmViewPager(ViewPager mViewPager) {
        this.mViewPager = mViewPager;
    }

    public void configure(Context context, TabsModule relatedMoviesVH, final Target[] target, final CardDetailListener mListener) {
        System.out.println("KKKKKKKKKKKKKK NavigationModule ");
        if (target != null && target.length > 0) {
            for (int i = 0; i < target.length; i++) {
                sectionList.add(mListener.requestSectionForTab(target[i].getSectionId()));
            }
            TabsModuleAdapter tabsModuleAdapter = new TabsModuleAdapter(mListener.requestFragmentManager(), sectionList);
            relatedMoviesVH.getmViewPager().setAdapter(tabsModuleAdapter);
        }
    }
}
