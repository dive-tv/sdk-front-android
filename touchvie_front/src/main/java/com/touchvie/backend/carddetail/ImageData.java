package com.touchvie.backend.carddetail;

/**
 * Created by Tagsonomy S.L. on 16/10/2016.
 */

public class ImageData {
    private String thumb;
    private String full;
    private int anchor_x;
    private int anchor_Y;
    private Source source;

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
        return anchor_Y;
    }

    public void setAnchorY(int anchor_Y) {
        this.anchor_Y = anchor_Y;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }
}
