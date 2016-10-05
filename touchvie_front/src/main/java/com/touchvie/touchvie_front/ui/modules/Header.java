package com.touchvie.touchvie_front.ui.modules;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.modules.viewholders.HeaderHolder;
import com.touchvie.touchvie_front.ui.views.Module;

/**
 * Created by Tagsonomy S.L. on 04/10/2016.
 */

public class Header extends Module {
    /**
     * Default constructor
     */
    public Header() {
        super();
        setLayout(R.layout.module_header);
    }

    @Override
    public RecyclerView.ViewHolder getViewHolder(LayoutInflater inflater, ViewGroup group) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(this.layout, group, false);
        HeaderHolder holder= new HeaderHolder(viewGroup);
        return holder;
    }
}