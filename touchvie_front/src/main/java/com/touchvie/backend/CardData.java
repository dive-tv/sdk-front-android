package com.touchvie.backend;

import java.io.Serializable;

/**
 * Created by rodrigo.moral on 16/09/2016.
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

}
