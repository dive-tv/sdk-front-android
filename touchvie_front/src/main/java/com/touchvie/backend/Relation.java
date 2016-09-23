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
     * The cards related to the card that owns the relation.
     */
    private Card cards;

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
    public Card getCards() {
        return cards;
    }

    public void setCards(Card cards) {
        this.cards = cards;
    }


}
