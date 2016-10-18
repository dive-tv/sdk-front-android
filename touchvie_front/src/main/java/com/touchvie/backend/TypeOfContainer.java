package com.touchvie.backend;

/**
 * Created by Tagsonomy S.L. on 10/10/2016.
 */

public enum TypeOfContainer {

    CATALOG("catalog"),
    DESCRIPTION("description"),
    BIOGRAPHY("biography"),
    OVERVIEW("overview"),
    GALLERY("gallery"),
    TEXT("text"),
    LISTING("listing"),
    RATING("rating"),
    MAP("map"),
    LINK("link"),
    AWARDS("awards"),
    SEASONS("seasons"),
    IMAGE("image");

    private final String name;

    TypeOfContainer(String s) {
        name = s;
    }

    public String getName() {
        return name;
    }
}
