package com.touchvie.touchvie_front.ui.modules;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.modules.viewholders.FullCuriosityHolder;
import com.touchvie.touchvie_front.ui.views.Module;

/**
 * Created by Tagsonomy S.L. on 13/10/2016.
 */

public class FullCuriosity  extends Module {
    /**
     * Default constructor
     */
    public FullCuriosity() {
        super();
        setLayout(R.layout.module_full_curiosity);
    }

    @Override
    public RecyclerView.ViewHolder getViewHolder(LayoutInflater inflater, ViewGroup group) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(this.layout, group, false);
        FullCuriosityHolder holder= new FullCuriosityHolder(viewGroup);
        return holder;
    }
}

