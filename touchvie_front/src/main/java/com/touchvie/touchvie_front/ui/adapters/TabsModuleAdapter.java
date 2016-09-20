package com.touchvie.touchvie_front.ui.adapters;

/**
 * Adapter to present a search movie list to do synchronization.
 */

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.touchvie.touchvie_front.ui.fragments.Section;

import java.util.ArrayList;

/**
 * The type Cards song belongs to adapter.
 */
public class TabsModuleAdapter extends FragmentStatePagerAdapter {

    private final ArrayList<Section> sections;
    Context context;

    public TabsModuleAdapter(FragmentManager fm, ArrayList<Section> sections) {
        super(fm);
        this.sections = sections;
    }

    /**
     * The number of items in the list. It is determined by the number of speeches in our array.
     *
     * @returns {int} length. The number of items in the providers list.
     */
    @Override
    public int getCount() {
        return sections.size();
    }

    /**
     * Since the data comes from an array, just returning the index is sufficient
     * to get at the data. If we were using a more complex data structure, we
     * would return whatever object represents one row in the list.
     *
     * @param {int} position. The object's position in the array.
     * @returns {Object} position. The object's position in the array
     */
    @Override
    public Fragment getItem(int position) {
        return sections.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return sections.get(position).getConfigSection().getTitle();
    }
}
