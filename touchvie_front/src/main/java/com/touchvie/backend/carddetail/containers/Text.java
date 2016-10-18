package com.touchvie.backend.carddetail.containers;

import com.touchvie.backend.carddetail.Source;

/**
 * Created by Tagsonomy S.L. on 17/10/2016.
 */

public class Text extends ContainerData {
    private String text;
    private Source source;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }
}
