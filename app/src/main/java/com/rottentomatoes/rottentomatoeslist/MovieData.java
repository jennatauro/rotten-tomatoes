package com.rottentomatoes.rottentomatoeslist;

public class MovieData {

    private String title;
    private String imageUrl;
    private String movieDetailURL;
    private String generalcons;
    private String synopsis;

    public MovieData(String title, String imageUrl, String movieDetailURL, String generalcons, String synopsis){
        super();
        this.title = title;
        this.imageUrl = imageUrl;
        this.movieDetailURL = movieDetailURL;
        this.generalcons = generalcons;
        this.synopsis = synopsis;
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

    public String getGeneralcons() {
        return generalcons;
    }

    public void setGeneralcons(String generalcons) {
        this.generalcons = generalcons;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

}