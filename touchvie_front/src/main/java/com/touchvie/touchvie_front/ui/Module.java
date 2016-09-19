package com.touchvie.touchvie_front.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 
 */
public class Module extends RecyclerView.ViewHolder{

    /**
     * Default constructor
     */
    public Module(View view) {
        super(view);
    }

    /**
     * Type of Module (from enum)
     */
    public String type;

    /**
     * Set Module type
     * @param modType 
     */
    public void setType(String modType) {
        this.type = modType;
    }

    /**
     * Get Module type
     * @return type
     */
    public String getType() {
        return type;
    }




}