package com.touchvie.touchvie_front.datatypes;

public class ModuleType {

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