package com.touchvie.touchvie_front.ui.modules;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.modules.viewholders.TrailerHolder;
import com.touchvie.touchvie_front.ui.modules.viewholders.VideoHolder;

/**
 * Created by Tagsonomy S.L. on 19/10/2016.
 */

public class Trailer extends VideoModule {

    public Trailer(){
        super();

    }
    @Override
    public RecyclerView.ViewHolder getViewHolder(LayoutInflater inflater, ViewGroup group) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(this.layout, group, false);
        TrailerHolder holder= new TrailerHolder(viewGroup);
        return holder;
    }
}
