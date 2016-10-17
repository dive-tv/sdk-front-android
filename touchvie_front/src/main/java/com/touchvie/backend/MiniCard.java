package com.touchvie.backend;

import java.io.Serializable;

/**
 * Created by Tagsonomy S.L. on 16/09/2016.
 */
public class MiniCard implements Serializable {
    String card_id;
    String title;
    String subtitle;
    String type;
    Image image;
    String source;
    int anchor_x;
    int anchor_y;
    Boolean is_exact;
    String url;

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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

    public Boolean getIs_exact() {
        return is_exact;
    }

    public void setIs_exact(Boolean is_exact) {
        this.is_exact = is_exact;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
