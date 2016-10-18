package com.touchvie.backend.carddetail.containers;

/**
 * Created by Tagsonomy S.L. on 17/10/2016.
 */

public class Seasons extends ContainerData {
    private int season_index;
    private int chapter_number;
    private String creators;
    private Image image;
    private int year;

    public int getSeasonIndex() {
        return season_index;
    }

    public void setSeasonIndex(int season_index) {
        this.season_index = season_index;
    }

    public int getChapterNumber() {
        return chapter_number;
    }

    public void setChapterNumber(int chapter_number) {
        this.chapter_number = chapter_number;
    }

    public String getCreators() {
        return creators;
    }

    public void setCreators(String creators) {
        this.creators = creators;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
