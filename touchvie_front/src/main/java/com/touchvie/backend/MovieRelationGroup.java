package com.touchvie.backend;

import java.io.Serializable;

/**
 * Created by Tagsonomy S.L. on 06/10/2016.
 */

public class MovieRelationGroup implements Serializable {

    Movie movie;
    Relation [] rel_types;


    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Relation[] getRelTypes() {
        return rel_types;
    }

    public void setRelTypes(Relation[] rel_types) {
        this.rel_types = rel_types;
    }

}
