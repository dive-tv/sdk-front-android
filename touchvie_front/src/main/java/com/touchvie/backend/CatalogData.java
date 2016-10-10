package com.touchvie.backend;


/**
 * Created by Tagsonomy S.L. on 10/10/2016.
 */

public class CatalogData extends Data {

    String background_image;
    String director;
    String[] genres;
    String original_title;
    Long runtime;
    Sync sync;
    Integer year;

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

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public Long getRuntime() {
        return runtime;
    }

    public void setRuntime(long runtime) {
        this.runtime = runtime;
    }

    public String getOriginalTitle() {
        return original_title;
    }

    public void setOriginalTitle(String original_title) {
        this.original_title = original_title;
    }

    public Sync getSync() {
        return sync;
    }

    public void setSync(Sync sync) {
        this.sync = sync;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
