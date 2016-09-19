package com.touchvie.backend;

import java.io.Serializable;

/**
 * Created by Tagsonomy S.L. on 16/09/2016.
 */
public class CardData implements Serializable {
    String card_id;
    String locale;
    String title;
    String subtitle;
    int type;
    String image;
    String source;
    int anchor_x;
    int anchor_y;
    Description description;
    Boolean is_exact;
    String url;
    Boolean is_user_locale;
    RelatedMovies related_movies;

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public RelatedMovies getRelated_movies() {
        return related_movies;
    }

    public void setRelated_movies(RelatedMovies related_movies) {
        this.related_movies = related_movies;
    }
}
