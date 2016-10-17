package com.touchvie.touchvie_front.ui.modules;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.touchvie.touchvie_front.ui.modules.viewholders.BasicInfoHolder;


/**
 * Created by Tagsonomy S.L. on 04/10/2016.
 */

public class BasicInfo extends TwoColsModule {
    /**
     * Default constructor
     */
    public BasicInfo() {
        super();
    }

    @Override
    public RecyclerView.ViewHolder getViewHolder(LayoutInflater inflater, ViewGroup group) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(this.layout, group, false);
        BasicInfoHolder holder= new BasicInfoHolder(viewGroup);
        return holder;
    }
}
