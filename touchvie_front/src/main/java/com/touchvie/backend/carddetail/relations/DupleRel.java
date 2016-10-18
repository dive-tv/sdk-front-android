package com.touchvie.backend.carddetail.relations;

import com.touchvie.backend.MiniCard;

/**
 * Created by Tagsonomy S.L. on 18/10/2016.
 */

public class DupleRel extends Relation{
    private String rel_type;
    private MiniCard from;
    private MiniCard to;

    public String getRelType() {
        return rel_type;
    }

    public void setRelType(String rel_type) {
        this.rel_type = rel_type;
    }

    public MiniCard getFrom() {
        return from;
    }

    public void setFrom(MiniCard from) {
        this.from = from;
    }

    public MiniCard getTo() {
        return to;
    }

    public void setTo(MiniCard to) {
        this.to = to;
    }
}
