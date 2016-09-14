package com.touchvie.sdkfront.builders;

import com.touchvie.sdkfront.datatypes.ModuleType;
import com.touchvie.sdkfront.datatypes.NavigationType;

import java.util.*;

/**
 * 
 */
public class ConfigSection {

    /**
     * Default constructor
     */
    public ConfigSection() {
    }

    /**
     * List of Modules in this Section
     */
    public ArrayList<ModuleType> modules;

    /**
     * Add new Module to the Section
     * @param modType 
     * @return
     */
    public void addModule(ModuleType modType) {
        // TODO implement here
        return;
    }

    /**
     * Add a new Navigation Module to another Section
     * @param targetSection Target Section
     * @param title Text in the button
     * @param type
     */
    public void addNavigation(String targetSection, String title, NavigationType type) {
        // TODO implement here
    }

    /**
     * Load the Modules style configuration
     * @return
     */
    public ArrayList<ModuleType> getModulesConfig() {
        // TODO implement here
        return null;
    }

}