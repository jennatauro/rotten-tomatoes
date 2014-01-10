package com.rottentomatoes.rottentomatoeslist;

public class MovieData {

    private String title;
    private String imageUrl;

    public MovieData(String title, String imageUrl){
        super();
        this.title = title;
        this.imageUrl = imageUrl;
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

}