package com.touchvie.backend.carddetail;

import com.touchvie.backend.CardData;

import java.io.Serializable;

/**
 * Created by Tagsonomy S.L. on 23/09/2016.
 */

public class Relation implements Serializable {

    /**
     * The type of relation.
     */
    private String type;

    /**
     *
     */
    private String content_type;

    /**
     * The related related to the related that owns the relation.
     */
    private CardData[] data;

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

    public String getContentType() {
        return content_type;
    }

    public void setContentType(String content_type) {
        this.content_type = content_type;
    }

    public CardData[] getData() {
        return data;
    }

    public void setData(CardData[] data) {
        this.data = data;
    }
}
