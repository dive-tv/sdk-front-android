package com.touchvie.touchvie_front.ui.modules;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.touchvie.touchvie_front.ui.modules.viewholders.OverviewHolder;


/**
 * Created by Tagsonomy S.L. on 18/10/2016.
 */

public class Overview  extends TextModule {


    public Overview() {
        super();
    }

    @Override
    public RecyclerView.ViewHolder getViewHolder(LayoutInflater inflater, ViewGroup group) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(this.layout, group, false);
        OverviewHolder holder= new OverviewHolder(viewGroup);
        return holder;
    }
}
