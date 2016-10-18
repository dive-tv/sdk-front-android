package com.touchvie.backend.carddetail.containers;

import com.touchvie.backend.carddetail.Source;

/**
 * Created by Tagsonomy S.L. on 17/10/2016.
 */

public class Rating extends ContainerData {
    private int value;
    private Source source;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }
}
