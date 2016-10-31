package com.touchvie.backend.carddetail;

/**
 * Created by Tagsonomy S.L. on 16/10/2016.
 */

public class ProductData {
    String product_id;
    String category;
    String title;
    String merchant;
    String image;
    String url;
    Float price;
    String currency;
    Boolean matching;
    String country;
    String region;
    String city;
    String address;
    Integer postal_code;
    Float rating;
    Source source;
    Boolean is_exact;
    Boolean is_up_to_date;

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Boolean isMatching() {
        return matching;
    }

    public void setMatching(Boolean matching) {
        this.matching = matching;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(Integer postal_code) {
        this.postal_code = postal_code;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }
    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public Boolean is_exact() {
        return is_exact;
    }

    public void setIs_exact(Boolean is_exact) {
        this.is_exact = is_exact;
    }

    public Boolean is_up_to_date() {
        return is_up_to_date;
    }

    public void setIs_up_to_date(Boolean is_up_to_date) {
        this.is_up_to_date = is_up_to_date;
    }
}
