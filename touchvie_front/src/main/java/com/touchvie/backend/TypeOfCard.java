package com.touchvie.backend;

/**
 * Created by Tagsonomy S.L. on 29/09/2016.
 */

public enum TypeOfCard {

    MOVIE("movie"),
    SERIE ("serie"),
    CHAPTER("chapter"),
    PERSON ("person"),
    CHARACTER("character"),
    VEHICLE("vehicle"),
    FASHION ("fashion"),
    LOCATION("location"),
    HISTORIC("historic"),
    TRIVIA ("trivia"),
    QUOTE("quote"),
    OST("ost"),
    HOME ("home"),
    TECHONOLOGY("technology"),
    ART("art"),
    SONG ("song"),
    LOOK("look"),
    TRAILER ("trailer"),
    WEAPON("weapon"),
    LEISURE_SPORT("leisure_sport"),
    HEALTH_BEAUTY ("health_beauty"),
    FOOD_DRINK("food_drink"),
    FAUNA_FLORA("fauna_flora"),
    BUSINESS ("business"),
    VIDEOCLIP("videoclip"),
    ACTION_EMOTION("action_emotion");


    private final String name;

    private TypeOfCard(String s) {
        name = s;
    }

    public String getName() {
        return name;
    }

}

