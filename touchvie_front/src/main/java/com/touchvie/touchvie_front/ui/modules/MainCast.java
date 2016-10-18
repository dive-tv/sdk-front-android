package com.touchvie.touchvie_front.ui.modules;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.touchvie.touchvie_front.ui.modules.viewholders.MainCastHolder;

/**
 * Created by Tagsonomy S.L. on 18/10/2016.
 */

public class MainCast  extends HorizontalListModule {

    public MainCast(){
        super();
    }

    @Override
    public RecyclerView.ViewHolder getViewHolder(LayoutInflater inflater, ViewGroup group) {

        ViewGroup viewGroup = (ViewGroup) inflater.inflate(this.layout, group, false);
        MainCastHolder holder= new MainCastHolder(viewGroup);
        return holder;
    }
}
