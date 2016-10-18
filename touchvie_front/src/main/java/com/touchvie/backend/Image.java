package com.touchvie.backend;


import com.touchvie.backend.carddetail.Source;

import java.io.Serializable;

/**
 * Created by Tagsonomy S.L. on 06/10/2016.
 */

public class Image implements Serializable{

    String thumb;
    String full;
    float anchor_x;
    float anchor_y;
    Source source;

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }

    public float getAnchorX() {
        return anchor_x;
    }

    public void setAnchorX(float anchor_x) {
        this.anchor_x = anchor_x;
    }

    public float getAnchorY() {
        return anchor_y;
    }

    public void setAnchorY(float anchor_y) {
        this.anchor_y = anchor_y;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }
}
