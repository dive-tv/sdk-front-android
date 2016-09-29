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
     * The card related to the card that owns the relation.
     */
    private Card card;

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
    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }


}
