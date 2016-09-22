package com.touchvie.touchvie_front.builders;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Tagsonomy S.L. on 15/09/2016.
 */
public class ConfigModule implements Serializable{

    protected String type;
    protected Target[] targets;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Target[] getTargets() {
        return targets;
    }

    public void setTargets(Target[] targets) {
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
