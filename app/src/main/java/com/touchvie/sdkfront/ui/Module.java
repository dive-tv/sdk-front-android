package com.touchvie.sdkfront.ui;

import com.touchvie.sdkfront.datatypes.JsonDataType;
import com.touchvie.sdkfront.datatypes.ModuleType;

import org.json.JSONObject;

import java.util.*;

/**
 * 
 */
public class Module {

    /**
     * Default constructor
     */
    public Module() {
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

}