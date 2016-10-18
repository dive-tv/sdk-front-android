package com.touchvie.touchvie_front.ui.modules;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.touchvie.touchvie_front.ui.modules.viewholders.AppearsInSingleHolder;

/**
 * Created by Tagsonomy S.L. on 18/10/2016.
 */

public class AppearsInSingle  extends SingleModule {

    public AppearsInSingle(){
        super();
    }

    @Override
    public RecyclerView.ViewHolder getViewHolder(LayoutInflater inflater, ViewGroup group) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(this.layout, group, false);
        AppearsInSingleHolder holder= new AppearsInSingleHolder(viewGroup);
        return holder;
    }
}
