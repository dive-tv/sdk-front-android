package com.touchvie.touchvie_front.ui.modules;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.modules.viewholders.HeaderButtonHolder;

/**
 * Created by Tagsonomy S.L. on 04/10/2016.
 */

public class ButtonHeader extends Header {
    /**
     * Default constructor
     */
    public ButtonHeader() {
        super();
        setLayout(R.layout.module_header_button);
    }

    @Override
    public RecyclerView.ViewHolder getViewHolder(LayoutInflater inflater, ViewGroup group) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(this.layout, group, false);
        HeaderButtonHolder holder= new HeaderButtonHolder(viewGroup);
        return holder;
    }
}
