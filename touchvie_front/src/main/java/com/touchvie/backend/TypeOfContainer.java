package com.touchvie.backend;

/**
 * Created by Tagsonomy S.L. on 10/10/2016.
 */

public enum TypeOfContainer {

    CATALOG("catalog"),
    DESCRIPTION("description"),
    BIOGRAPHY("biography"),
    OVERVIEW("overview");

    private final String name;

    TypeOfContainer(String s) {
        name = s;
    }

    public String getName() {
        return name;
    }
}
