package com.touchvie.touchvie_front.ui.views;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 *
 */
public abstract class Module {

    /**
     * Type of module
     */
    protected String type;

    /**
     * XML layout to inflate the viewholder of this module.
     */
    protected Integer layout;

    /**
     * Default constructor
     */
    public Module() {

    }

    /**
     * Sets the module type
     * @param modType type of the Module
     */
    public void setType(String modType) {
        this.type = modType;
    }

    /**
     * Gets the module type
     * @return type the type of the module
     */
    public String getType() {
        return type;
    }


    public Integer getLayout() {
        return layout;
    }

    public void setLayout(Integer layout) {
        this.layout = layout;
    }


    public abstract RecyclerView.ViewHolder getViewHolder(LayoutInflater inflater, ViewGroup group);
}