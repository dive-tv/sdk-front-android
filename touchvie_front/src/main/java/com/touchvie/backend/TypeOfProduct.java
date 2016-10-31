package com.touchvie.backend;

/**
 * Created by Noemi on 31/10/2016.
 */

public enum TypeOfProduct {

    FASHION("fashion"),
    TRAVEL("travel");

    private final String name;

    TypeOfProduct(String s) {
        name = s;
    }

    public String getName() {
        return name;
    }
}
