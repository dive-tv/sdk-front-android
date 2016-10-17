package com.touchvie.backend;

/**
 * Created by Tagsonomy S.L. on 10/10/2016.
 */

public class TextData extends Data {

    String text;
    Source source;

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
