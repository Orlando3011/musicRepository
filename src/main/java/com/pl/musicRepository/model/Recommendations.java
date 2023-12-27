package com.pl.musicRepository.model;

import java.util.List;

public class Recommendations {
    private String favouriteGenre;
    private String favouriteSong;
    private String favouriteAuthor;

    private Integer songsCount;

    private List<Record> recommendedByArtist;
    private List<Record> recommendedByGenre;
    private List<Record> recommendedByRandom;


    public String getFavouriteGenre() {
        return favouriteGenre;
    }

    public void setFavouriteGenre(String favouriteGenre) {
        this.favouriteGenre = favouriteGenre;
    }

    public String getFavouriteSong() {
        return favouriteSong;
    }

    public void setFavouriteSong(String favouriteSong) {
        this.favouriteSong = favouriteSong;
    }

    public String getFavouriteAuthor() {
        return favouriteAuthor;
    }

    public void setFavouriteAuthor(String favouriteAuthor) {
        this.favouriteAuthor = favouriteAuthor;
    }

    public List<Record> getRecommendedByArtist() {
        return recommendedByArtist;
    }

    public void setRecommendedByArtist(List<Record> recommendedByArtist) {
        this.recommendedByArtist = recommendedByArtist;
    }

    public List<Record> getRecommendedByGenre() {
        return recommendedByGenre;
    }

    public void setRecommendedByGenre(List<Record> recommendedByGenre) {
        this.recommendedByGenre = recommendedByGenre;
    }

    public List<Record> getRecommendedByRandom() {
        return recommendedByRandom;
    }

    public void setRecommendedByRandom(List<Record> recommendedByRandom) {
        this.recommendedByRandom = recommendedByRandom;
    }

    public Integer getSongsCount() {
        return songsCount;
    }

    public void setSongsCount(Integer songsCount) {
        this.songsCount = songsCount;
    }
}
