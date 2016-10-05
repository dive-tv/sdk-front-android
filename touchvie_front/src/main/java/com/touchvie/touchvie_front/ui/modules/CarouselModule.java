package com.touchvie.touchvie_front.ui.modules;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.touchvie.touchvie_front.ui.modules.viewholders.CarouselHolder;
import com.touchvie.touchvie_front.ui.views.Module;

/**
 * Created by Tagsonomy S.L. on 04/10/2016.
 */

public class CarouselModule extends Module {

    /**
     * Default constructor
     *
     */
    public CarouselModule() {
        super();
    }

    @Override
    public RecyclerView.ViewHolder getViewHolder(LayoutInflater inflater, ViewGroup group) {

        ViewGroup viewGroup = (ViewGroup) inflater.inflate(this.layout, group, false);
        CarouselHolder holder= new CarouselHolder(viewGroup);
        return holder;
    }
}
