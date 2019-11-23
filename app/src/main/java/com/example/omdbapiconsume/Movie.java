package com.example.omdbapiconsume;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie {
    @JsonProperty("Title")
    private String title;
    @JsonProperty("Year")
    private String year;
    @JsonProperty("imdbID")
    private String imdbID;
    @JsonProperty("Type")
    private MovieType type;
    @JsonProperty("Poster")
    private String posterURL;

    public Movie() {
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getImdbID() {
        return imdbID;
    }

    public MovieType getType() {
        return type;
    }

    public String getPosterURL() {
        return posterURL;
    }
}
