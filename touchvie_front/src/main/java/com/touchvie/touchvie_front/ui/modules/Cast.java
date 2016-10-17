package com.touchvie.touchvie_front.ui.modules;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.touchvie.touchvie_front.ui.modules.viewholders.CastHolder;

/**
 * Created by Tagsonomy S.L. on 04/10/2016.
 */

public class Cast extends HorizontalListModule {

    /**
     * Default constructor
     */
    public Cast() {
        super();
    }

    @Override
    public RecyclerView.ViewHolder getViewHolder(LayoutInflater inflater, ViewGroup group) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(this.layout, group, false);
        CastHolder holder= new CastHolder(viewGroup);
        return holder;
    }
}
