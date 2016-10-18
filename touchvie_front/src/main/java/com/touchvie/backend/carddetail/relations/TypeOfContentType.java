package com.touchvie.backend.carddetail.relations;

/**
 * Created by Tagsonomy S.L. on 10/10/2016.
 */

public enum TypeOfContentType {

    //Singles relations
    MOVIE_TRIVIAS("movie_trivias"),
    MOVIE_VEHICLES("movie_vehicles"),
    MOVIE_HIGHLIGHTED("movie_highlighted"),
    RECOMMENDED("recommended"),
    DIRECTORS("directors"),
    VEHICLE_APPEARS_IN("vehicle_appears_in"),
    FASHION_APEARS_IN("fashion_appears_in"),
    TECHNOLOGY_APEARS_IN("technology_appears_in"),
    ART_APEARS_IN("art_appears_in"),
    TRIVIA_APEARS_IN("trivia_appears_in"),
    FULL_LOOKS("full_looks"),
    LOOK_FASHION("look_fashion"),
    OTHER_LOOKS("other_looks"),
    TRACKLIST("tracklist"),
    SOUND_IN("sounds_in"),
    ITEM_TRIVIAS("item_trivias"),
    //Duple Realtions
    CASTING("casting"),
    MOVIE_LOCATIONS("movie_locations"),
    FILMOGRAPHY("filmography"),
    WORN_BY("worn_by"),
    FEATURES_IN("featured_in");

    private final String name;

    TypeOfContentType(String s) {
        name = s;
    }

    public String getName() {
        return name;
    }
}
