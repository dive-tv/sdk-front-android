package com.touchvie.touchvie_front.builders;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Tagsonomy S.L. on 15/09/2016.
 */
public class ConfigModule implements Serializable{

    protected String moduleType;
    protected ArrayList<Target> targets;

    public String getModuleType() {
        return moduleType;
    }

    public void setModuleType(String moduleType) {
        this.moduleType = moduleType;
    }

    public ArrayList<Target> getTargets() {
        return targets;
    }

    public void setTargets(ArrayList<Target> targets) {
        this.targets = targets;
    }

    /**
     * Check if class exists.
     *
     * @param className name of the class we are looking for
     * @return boolean whether it exists or not
     */
    public boolean isClass(String className) {
        try {
            Class.forName(className);
            return true;
        } catch (final ClassNotFoundException e) {
            return false;
        }
    }
}
