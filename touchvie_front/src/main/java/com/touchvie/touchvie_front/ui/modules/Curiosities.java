package com.touchvie.touchvie_front.ui.modules;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.touchvie.touchvie_front.ui.modules.viewholders.CuriositiesHolder;

/**
 * Created by Tagsonomy S.L. on 04/10/2016.
 */

public class Curiosities extends HorizontalListModule {

    public Curiosities(){
        super();
    }

    @Override
    public RecyclerView.ViewHolder getViewHolder(LayoutInflater inflater, ViewGroup group) {

        ViewGroup viewGroup = (ViewGroup) inflater.inflate(this.layout, group, false);
        CuriositiesHolder holder= new CuriositiesHolder(viewGroup);
        return holder;
    }
}