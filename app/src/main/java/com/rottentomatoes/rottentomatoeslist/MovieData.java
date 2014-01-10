package com.rottentomatoes.rottentomatoeslist;

public class MovieData {

    private String title;
    private String imageUrl;
    private String movieDetailURL;

    public MovieData(String title, String imageUrl, String movieDetailURL){
        super();
        this.title = title;
        this.imageUrl = imageUrl;
        this.movieDetailURL = movieDetailURL;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getMovieDetailURL() {
        return movieDetailURL;
    }

    public void setMovieDetailURL(String movieDetailURL) {
        this.movieDetailURL = movieDetailURL;
    }

}