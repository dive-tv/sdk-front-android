package com.touchvie.backend;

import com.touchvie.backend.carddetail.Container;
import com.touchvie.backend.carddetail.ImageData;
import com.touchvie.backend.carddetail.ProductData;
import com.touchvie.backend.carddetail.relations.Relation;
import com.touchvie.backend.carddetail.User;

/**
 * Created by Tagsonomy S.L. on 16/09/2016.
 */
public class Card {

    private String card_id;
    private String type;
    private String locale;
    private String title;
    private String subtitle;
    private ImageData image;
    private ProductData[] products;
    private Container[] info;
    private Relation[] relations;
    private User user;

    public String getCardId() {
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

    public ImageData getImage() {
        return image;
    }

    public void setImage(ImageData image) {
        this.image = image;
    }

    public ProductData[] getProducts() {
        return products;
    }

    public void setProducts(ProductData[] products) {
        this.products = products;
    }

    public Container[] getInfo() {
        return info;
    }

    public void setInfo(Container[] info) {
        this.info = info;
    }

    public Relation[] getRelations() {
        return relations;
    }

    public void setRelations(Relation[] relations) {
        this.relations = relations;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
