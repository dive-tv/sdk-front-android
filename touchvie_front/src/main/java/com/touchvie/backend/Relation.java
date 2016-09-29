package com.touchvie.backend;

/**
 * Created by Tagsonomy S.L. on 23/09/2016.
 */

public class Relation {

    /**
     * The type of relation.
     */
    private int type;

    /**
     * The rel_cards related to the rel_cards that owns the relation.
     */
    private Card[] rel_cards;

    /**
     * Gets the type of the relation.
     * @return
     */
    public int getType() {
        return type;
    }

    /**
     * Sets the type of the relation.
     * @param type The type to be set.
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     *
     * @return
     */
    public Card[] getRel_cards() {
        return rel_cards;
    }

    public void setRel_cards(Card[] rel_cards) {
        this.rel_cards = rel_cards;
    }


}
