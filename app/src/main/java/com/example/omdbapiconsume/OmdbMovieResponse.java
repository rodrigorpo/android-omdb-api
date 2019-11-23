package com.example.omdbapiconsume;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OmdbMovieResponse {

    @JsonProperty("Search")
    private List<Movie> search;
    private Integer totalResults;
    @JsonProperty("Response")
    private Boolean response;

    public OmdbMovieResponse() {
    }

    public OmdbMovieResponse(List<Movie> search, Integer totalResults, Boolean response) {
        this.search = search;
        this.totalResults = totalResults;
        this.response = response;
    }

    public List<Movie> getSearch() {
        return search;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setSearch(List<Movie> search) {
        this.search = search;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public Boolean getResponse() {
        return response;
    }

    public void setResponse(Boolean response) {
        this.response = response;
    }
}
