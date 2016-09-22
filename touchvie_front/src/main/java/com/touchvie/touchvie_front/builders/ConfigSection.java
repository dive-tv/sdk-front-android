package com.touchvie.touchvie_front.builders;

import java.io.Serializable;

/**
 *
 */
public class ConfigSection implements Serializable {


    /**
     * List of the configurations for the modules in this Section
     */
    protected ConfigModule[] modules;

    /**
     * The title of this section
     */
    protected String title;

    /**
     * Whether this section is the main one of a card detail.
     */
    protected boolean main;

    /**
     * Default constructor
     */
    public ConfigSection() {
    }

    /**
     * Sets the config of the modules for the section to be built from this configuration.
     * @param modules
     */

    public void setModules(ConfigModule[] modules) {
        this.modules = modules;
    }

    /**
     * Gets all the configurations for the modules of this section.
     * @return
     */
    public ConfigModule[] getConfigModules() {
        return modules;
    }

    /**
     * Gets the title of this section.
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of this section.
     * @param title The title to be set.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Checks whether this section is the main one of a card detail.
     * @return
     */
    public boolean isMain() {
        return main;
    }

    /**
     * Sets whether this section is the main one of a card detail.
     * @param main true if is the main section, false otherwise.
     */
    public void setMain(boolean main) {
        this.main = main;
    }


}