package com.touchvie.backend;


import com.touchvie.backend.carddetail.Source;

import java.io.Serializable;

/**
 * Created by Tagsonomy S.L. on 06/10/2016.
 */

public class Image implements Serializable{

    String thumb;
    String full;
    int anchor_x;
    int anchor_y;
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

    public int getAnchorX() {
        return anchor_x;
    }

    public void setAnchorX(int anchor_x) {
        this.anchor_x = anchor_x;
    }

    public int getAnchorY() {
        return anchor_y;
    }

    public void setAnchorY(int anchor_y) {
        this.anchor_y = anchor_y;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }
}
