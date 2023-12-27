package com.pl.musicRepository.service;

import com.pl.musicRepository.model.History;
import com.pl.musicRepository.model.Recommendations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Map.Entry;

@Service
public class RecommendationsService {
    @Autowired
    private HistoryService historyService;

    @Autowired
    private RecordService recordService;

    public Recommendations createRecommendations() {
        return prepareRecommendations(historyService.findAllHistory());
    }

    private Recommendations prepareRecommendations(List<History> historyList) {
        Recommendations recommendations = new Recommendations();

        recommendations.setSongsCount(recordService.findAllRecords().size());
        prepareFavouriteGenre(historyList, recommendations);
        prepareFavouriteAuthor(historyList, recommendations);
        prepareFavouriteSong(historyList, recommendations);

        return recommendations;
    }

    private void prepareFavouriteGenre(List<History> historyList, Recommendations recommendations) {
        Map<String, Integer> favouriteGenres = new HashMap<>();
        for (History history:historyList) {
            String genre = history.getRecord().getGenre();
            if(favouriteGenres.containsKey(genre))
                favouriteGenres.put(genre, favouriteGenres.get(genre) + 1);
            else
                favouriteGenres.put(genre, 1);
        }

        Optional<Entry<String, Integer>> favouriteGenre = favouriteGenres.entrySet().stream().max(Entry.comparingByValue());
        favouriteGenre.ifPresent(stringIntegerEntry -> recommendations.setFavouriteGenre(stringIntegerEntry.getKey()));
    }

    private void prepareFavouriteAuthor(List<History> historyList, Recommendations recommendations) {
        Map<String, Integer> favouriteAuthors = new HashMap<>();
        for (History history:historyList) {
            String author = history.getRecord().getAuthor();
            if(favouriteAuthors.containsKey(author))
                favouriteAuthors.put(author, favouriteAuthors.get(author) + 1);
            else
                favouriteAuthors.put(author, 1);
        }

        Optional<Entry<String, Integer>> favouriteAuthor = favouriteAuthors.entrySet().stream().max(Entry.comparingByValue());
        favouriteAuthor.ifPresent(stringIntegerEntry -> recommendations.setFavouriteAuthor(stringIntegerEntry.getKey()));
    }

    private void prepareFavouriteSong(List<History> historyList, Recommendations recommendations) {
        Map<String, Integer> favouriteSongs = new HashMap<>();
        for (History history:historyList) {
            String song = history.getRecord().getName();
            if(favouriteSongs.containsKey(song))
                favouriteSongs.put(song, favouriteSongs.get(song) + 1);
            else
                favouriteSongs.put(song, 1);
        }

        Optional<Entry<String, Integer>> favouriteSong = favouriteSongs.entrySet().stream().max(Entry.comparingByValue());
        favouriteSong.ifPresent(stringIntegerEntry -> recommendations.setFavouriteSong(stringIntegerEntry.getKey()));
    }

    private void prepareGenreRecommendations(List<History> historyList, Recommendations recommendations) {
    }

    private void prepareAuthorRecommendations(List<History> historyList, Recommendations recommendations) {

    }
}
