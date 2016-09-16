package com.touchvie.sdk_front.builders;

import com.touchvie.sdk_front.datatypes.ModuleType;

import java.util.ArrayList;

/**
 * Created by noemi.leon on 15/09/2016.
 */
public class ConfigModule {

    protected ModuleType moduleType;
    protected ArrayList<Target> targets;

    public ModuleType getModuleType() {
        return moduleType;
    }

    public void setModuleType(ModuleType moduleType) {
        this.moduleType = moduleType;
    }

    public ArrayList<Target> getTargets() {
        return targets;
    }

    public void setTargets(ArrayList<Target> targets) {
        this.targets = targets;
    }

}
