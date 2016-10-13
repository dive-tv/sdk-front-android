package com.touchvie.touchvie_front.ui.modules;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.touchvie.touchvie_front.ui.modules.viewholders.ShopHolder;

/**
 * Created by Tagsonomy S.L. on 13/10/2016.
 */

public class Shop extends CarouselModule {

    public Shop(){
        super();
    }

    @Override
    public RecyclerView.ViewHolder getViewHolder(LayoutInflater inflater, ViewGroup group) {

        ViewGroup viewGroup = (ViewGroup) inflater.inflate(this.layout, group, false);
        ShopHolder holder= new ShopHolder(viewGroup);
        return holder;
    }
}
