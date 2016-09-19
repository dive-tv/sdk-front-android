package com.touchvie.backend;

/**
 * Created by Tagsonomy S.L. on 19/09/2016.
 */
public class Movies {
    int type;
    String image;
    int anchor_x;
    int anchor_y;
    String title;
    String subtitle;
    Boolean touchvie_ready;
    float mean_score;
    int year;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getAnchor_x() {
        return anchor_x;
    }

    public void setAnchor_x(int anchor_x) {
        this.anchor_x = anchor_x;
    }

    public int getAnchor_y() {
        return anchor_y;
    }

    public void setAnchor_y(int anchor_y) {
        this.anchor_y = anchor_y;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Boolean getTouchvie_ready() {
        return touchvie_ready;
    }

    public void setTouchvie_ready(Boolean touchvie_ready) {
        this.touchvie_ready = touchvie_ready;
    }

    public float getMean_score() {
        return mean_score;
    }

    public void setMean_score(float mean_score) {
        this.mean_score = mean_score;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
