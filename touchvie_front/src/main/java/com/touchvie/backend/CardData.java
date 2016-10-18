package com.touchvie.backend;

import com.touchvie.backend.carddetail.relations.Relation;

import java.util.ArrayList;

/**
 * Created by Tagsonomy S.L. on 17/10/2016.
 */

public class CardData {
    private MiniCard miniCard;
    private ArrayList<Relation> relation;

    public MiniCard getMiniCard() {
        return miniCard;
    }

    public void setMiniCard(MiniCard miniCard) {
        this.miniCard = miniCard;
    }

    public ArrayList<Relation> getRelation() {
        return relation;
    }

    public void setRelation(ArrayList<Relation> relation) {
        this.relation = relation;
    }
}
