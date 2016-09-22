package com.touchvie.touchvie_front.builders;

import java.io.Serializable;

/**
 * Created by Tagsonomy S.L. on 15/09/2016.
 */
public class Target implements Serializable {

    private String sectionId;
    private String text;

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
