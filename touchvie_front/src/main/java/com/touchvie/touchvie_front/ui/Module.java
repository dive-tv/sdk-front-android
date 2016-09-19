package com.touchvie.touchvie_front.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.touchvie.backend.CardData;
import com.touchvie.touchvie_front.datatypes.JsonDataType;
import com.touchvie.touchvie_front.datatypes.ModuleType;

import org.json.JSONObject;

import java.util.*;

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
    public ModuleType type;

    /**
     * Set Module type
     * @param modType 
     * @return
     */
    public void setType(ModuleType modType) {
        // TODO implement here
    }

    /**
     * Get Module type
     * @return
     */
    public ModuleType getType() {
        // TODO implement here
        return null;
    }




}