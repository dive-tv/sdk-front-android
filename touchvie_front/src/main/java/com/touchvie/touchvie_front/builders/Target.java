package com.touchvie.touchvie_front.builders;

import java.io.Serializable;

/**
 * Created by Tagsonomy S.L. on 15/09/2016.
 */
public class Target implements Serializable {

    /**
     * The section target identifier.
     */
    protected String sectionId;

    /**
     * The section target text.
     */
    protected String text;

    /**
     * Gets the target section identifier.
     * @return
     */
    public String getSectionId() {
        return sectionId;
    }

    /**
     * Sets the target section identifier
     * @param sectionId The identifier to be set.
     */
    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    /**
     * Gets the text of this target.
     * @return
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the text of this target.
     * @param text The text to be set.
     */
    public void setText(String text) {
        this.text = text;
    }

}
