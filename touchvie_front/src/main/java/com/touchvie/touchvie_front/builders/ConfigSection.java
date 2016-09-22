package com.touchvie.touchvie_front.builders;

import java.io.Serializable;
import java.util.ArrayList;

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
    protected ArrayList<ConfigModule> modules = new ArrayList<>();

    protected String title;

    protected boolean main;

    /**
     * Add new Module to the Section
     *
     * @param moduleType type of the module
     * @return
     */
    public void addModule(String moduleType) {
        ConfigModule newModule = new ConfigModule();
        newModule.setType(moduleType);
        modules.add(newModule);
    }

    /**
     * Add a new Navigation Module to another Section
     *
     * @param target Target Section
     */
    public void addNavigation(Target target) {
        ConfigModule newModule = new ConfigModule();
        newModule.setType("navigation");
        Target[] targetArray = new Target[1];
        targetArray[0] = target;
        newModule.setTargets(targetArray);
        modules.add(newModule);
    }

    /**
     * Add a new Navigation Module to another Section
     *
     * @param targets Array of Target Sections
     */
    public void addTabs(Target[] targets) {
        ConfigModule newModule = new ConfigModule();
        newModule.setType("tabs");
        Target[] targetArray = new Target[targets.length];
        System.arraycopy(targets, 0, targetArray, 0, targetArray.length);
        newModule.setTargets(targetArray);
        modules.add(newModule);
    }

    /**
     * Load the Modules style configuration
     *
     * @return
     */
    public ConfigModule[] getConfigModules() {

        return modules.toArray(new ConfigModule[modules.size()]);
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