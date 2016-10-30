package com.touchvie.backend.carddetail;

/**
 * Created by Tagsonomy S.L. on 16/10/2016.
 */

public class ImageData {
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

    public void setAnchorY(int anchor_Y) {
        this.anchor_y = anchor_Y;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }
}
