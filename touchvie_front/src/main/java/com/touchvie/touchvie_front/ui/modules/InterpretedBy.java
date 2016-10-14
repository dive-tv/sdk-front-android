package com.touchvie.touchvie_front.ui.modules;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.touchvie.touchvie_front.ui.modules.viewholders.InterpretedByHolder;

/**
 * Created by Tagsonomy S.L. on 13/10/2016.
 */

public class InterpretedBy extends HorizontalListModule {

    public InterpretedBy(){
        super();
    }

    @Override
    public RecyclerView.ViewHolder getViewHolder(LayoutInflater inflater, ViewGroup group) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(this.layout, group, false);
        InterpretedByHolder holder= new InterpretedByHolder(viewGroup);
        return holder;
    }
}
