package com.touchvie.backend;

/**
 * Created by Tagsonomy S.L. on 23/09/2016.
 */

public class Relation {

    /**
     * The type of relation.
     */
    private String type;

    /**
     * The related related to the related that owns the relation.
     */
    private CardData[] related;

    /**
     * Gets the type of the relation.
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the relation.
     * @param type The type to be set.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     */
    public CardData[] getRelated() {
        return related;
    }

    public void setRelated(CardData[] related) {
        this.related = related;
    }


}
