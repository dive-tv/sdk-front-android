package com.touchvie.backend;

/**
 * Created by Tagsonomy S.L. on 19/09/2016.
 */
public class RelatedMovies {
    String title;
    String type;
    String type_data;
    Movies movies[];
    String summary;
    String movie_id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType_data() {
        return type_data;
    }

    public void setType_data(String type_data) {
        this.type_data = type_data;
    }

    public Movies[] getMovies() {
        return movies;
    }

    public void setMovies(Movies[] movies) {
        this.movies = movies;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(String movie_id) {
        this.movie_id = movie_id;
    }
}
