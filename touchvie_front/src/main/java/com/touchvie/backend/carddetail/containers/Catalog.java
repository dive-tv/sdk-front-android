package com.touchvie.backend.carddetail.containers;

/**
 * Created by Tagsonomy S.L. on 17/10/2016.
 */

public class Catalog extends ContainerData {
    private String background_image;
    private String director;
    private String genres;
    private String original_title;
    private int runtime;
    private int year;
    private Synchro sync;
    private String creators;
    private String serie_title;
    private int chapter_index;
    private int season_index;

    public String getBackgroundImage() {
        return background_image;
    }

    public void setBackgroundImage(String background_image) {
        this.background_image = background_image;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getOriginalTitle() {
        return original_title;
    }

    public void setOriginalTitle(String original_title) {
        this.original_title = original_title;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Synchro getSync() {
        return sync;
    }

    public void setSync(Synchro sync) {
        this.sync = sync;
    }

    public String getCreators() {
        return creators;
    }

    public void setCreators(String creators) {
        this.creators = creators;
    }

    public String getSerieTitle() {
        return serie_title;
    }

    public void setSerieTitle(String serie_title) {
        this.serie_title = serie_title;
    }

    public int getChapterIndex() {
        return chapter_index;
    }

    public void setChapterIndex(int chapter_index) {
        this.chapter_index = chapter_index;
    }

    public int getSeasonIndex() {
        return season_index;
    }

    public void setSeasonIndex(int season_index) {
        this.season_index = season_index;
    }
}
