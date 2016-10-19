package com.touchvie.touchvie_front.ui.modules;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.touchvie.touchvie_front.ui.modules.viewholders.SongsHolder;

/**
 * Created by Tagsonomy S.L. on 13/10/2016.
 */

public class Songs extends VerticalListModule {

    public Songs(){
        super();
    }

    @Override
    public RecyclerView.ViewHolder getViewHolder(LayoutInflater inflater, ViewGroup group) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(this.layout, group, false);
        SongsHolder holder= new SongsHolder(viewGroup);
        return holder;
    }
}

