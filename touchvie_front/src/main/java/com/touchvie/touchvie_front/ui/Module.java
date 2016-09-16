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

    /**
     * Static method to check whether the module can be created with the given data or not.
     * @param json 
     * @param modType 
     * @param arguments 
     * @return
     */
    public static boolean validate(JSONObject json, ModuleType modType, JsonDataType arguments) {
        // TODO implement here
        return false;
    }

    /**
     * Static method to check whether the module can be created with the given data or not.
     * @param data
     * @param modType
     * @return
     */
    public static boolean validate(CardData data, String modType) {
        // TODO implement here.

        ArrayList<JsonDataType> datatypes=new ArrayList<>();

        switch(modType){
            case "Gallery":
                break;
            case "Header":
                break;


        }


        return false;
    }

}