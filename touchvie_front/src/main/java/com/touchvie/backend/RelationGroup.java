package com.touchvie.backend;

import com.touchvie.backend.carddetail.relations.Relation;

import java.io.Serializable;

/**
 * Created by Tagsonomy S.L. on 06/10/2016.
 */

public class RelationGroup implements Serializable {

    Relation[] off_movie ;

    MovieRelationGroup [] on_movie;

    public Relation[] getOffMovie() {
        return off_movie;
    }

    public void setOffMovie(Relation[] off_movie) {
        this.off_movie = off_movie;
    }

    public MovieRelationGroup [] getOnMovie() {
        return on_movie;
    }

    public void setOnMovie(MovieRelationGroup[] on_movie) {
        this.on_movie = on_movie;
    }

}
