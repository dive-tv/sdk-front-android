package com.touchvie.backend.carddetail.containers;

/**
 * Created by Tagsonomy S.L. on 17/10/2016.
 */

public class Listing extends ContainerData {
    private String text;
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
