package com.touchvie.backend;

import com.touchvie.backend.carddetail.ProductData;
import com.touchvie.touchvie_client.rest.datawrappers.NetworkData;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Tagsonomy S.L. on 16/09/2016.
 */
public class MiniCard extends NetworkData implements Serializable {
    private String card_id;
    private String type;
    private String locale;
    private String title;
    private String subtitle;
    private Image image;
    private ArrayList<ProductData> products;

    public String getCardId() {
        return card_id;
    }

    public void setCardId(String card_id) {
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

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public ArrayList<ProductData> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<ProductData> products) {
        this.products = products;
    }
}
