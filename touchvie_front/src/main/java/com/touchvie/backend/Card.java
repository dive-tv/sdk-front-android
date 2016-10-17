package com.touchvie.backend;

import java.io.Serializable;

/**
 * Created by Tagsonomy S.L. on 16/09/2016.
 */
public class Card implements Serializable {

    String card_id;
    String type;
    String locale;
    String title;
    String subtitle;
    Image image;
    Container [] containers;
    RelationGroup relations;
    User user;

    public String getCarId() {
        return card_id;
    }

    public void setCardId(String card_id) {
        this.card_id = card_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Container[] getContainers() {
        return containers;
    }

    public void setContainers(Container[] containers) {
        this.containers = containers;
    }

    public RelationGroup getRelations() {
        return relations;
    }

    public void setRelations(RelationGroup relations) {
        this.relations = relations;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



}
