package com.touchvie.touchvie_front.ui.modules;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.touchvie.touchvie_front.ui.modules.viewholders.VehicleListHolder;

/**
 * Created by Tagsonomy S.L. on 13/10/2016.
 */

public class PlacesShownList extends VerticalListModule {

    public PlacesShownList(){
        super();
    }

    @Override
    public RecyclerView.ViewHolder getViewHolder(LayoutInflater inflater, ViewGroup group) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(this.layout, group, false);
        VehicleListHolder holder= new VehicleListHolder(viewGroup);
        return holder;
    }
}
