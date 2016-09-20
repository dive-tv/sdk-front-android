package com.touchvie.touchvie_front.builders;

import java.io.Serializable;

/**
 *
 */
public class ConfigSection implements Serializable {

    /**
     * Default constructor
     */
    public ConfigSection() {
    }

    /**
     * List of Modules in this Section
     */
    protected ConfigModule[] modules;

    protected String title;

    protected boolean main;

    /**
     * Add new Module to the Section
     *
     * @param modType
     * @return
     */
    public void addModule(String modType) {
        // TODO implement here
        return;
    }

    /**
     * Add a new Navigation Module to another Section
     *
     * @param targetSection Target Section
     * @param title         Text in the button
     */
    public void addNavigation(String targetSection, String title) {
        // TODO implement here
    }

    /**
     * Load the Modules style configuration
     *
     * @return
     */
    public ConfigModule[] getConfigModules() {
        return modules;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isMain() {
        return main;
    }

    public void setMain(boolean main) {
        this.main = main;
    }


}