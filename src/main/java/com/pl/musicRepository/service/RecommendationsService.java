package com.pl.musicRepository.service;

import com.pl.musicRepository.model.History;
import com.pl.musicRepository.model.Recommendations;
import com.pl.musicRepository.model.Record;
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

    private List<Record> recordsList;
    private List<History> historyList;
    private Recommendations recommendations;

    public Recommendations createRecommendations() {
        recordsList = recordService.findAllRecords();
        historyList = historyService.findAllHistory();
        recommendations = new Recommendations();

        return prepareRecommendations();
    }

    private Recommendations prepareRecommendations() {

        recommendations.setSongsCount(recordService.findAllRecords().size());
        prepareFavouriteGenre();
        prepareFavouriteAuthor();
        prepareFavouriteSong();

        prepareRandomRecommendations();
        prepareAuthorRecommendations();
        prepareGenreRecommendations();

        return recommendations;
    }

    private void prepareFavouriteGenre() {
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

    private void prepareFavouriteAuthor() {
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

    private void prepareFavouriteSong() {
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

    private void prepareGenreRecommendations() {
        List<Record> recordsWithFavouriteGenre = new ArrayList<>();
        List<Record> randomRecords = new ArrayList<>();
        for (Record record:recordsList) {
            if(record.getGenre().equals(recommendations.getFavouriteGenre())) {
                recordsWithFavouriteGenre.add(record);
            }
        }
        if(recordsWithFavouriteGenre.size() < 3) randomRecords = recordsWithFavouriteGenre;
        else {
            Random random = new Random();
            for (int i = 0; i < 3; i++) {
                int randomIndex = random.nextInt(recordsList.size());
                Record record = recordsWithFavouriteGenre.get(randomIndex);
                recordsWithFavouriteGenre.remove(randomIndex);
                randomRecords.add(record);
            }
        }
        recommendations.setRecommendedByGenre(randomRecords);
    }

    private void prepareAuthorRecommendations() {
        List<Record> recordsWithFavouriteAuthor = new ArrayList<>();
        List<Record> randomRecords = new ArrayList<>();
        for (Record record:recordsList) {
            if(record.getAuthor().equals(recommendations.getFavouriteAuthor())) {
                recordsWithFavouriteAuthor.add(record);
            }
        }
        if(recordsWithFavouriteAuthor.size() < 3) randomRecords = recordsWithFavouriteAuthor;
        else {
            Random random = new Random();
            for (int i = 0; i < 3; i++) {
                int randomIndex = random.nextInt(recordsList.size());
                Record record = recordsWithFavouriteAuthor.get(randomIndex);
                recordsWithFavouriteAuthor.remove(randomIndex);
                randomRecords.add(record);
            }
        }
        recommendations.setRecommendedByArtist(randomRecords);
    }

    private void prepareRandomRecommendations() {
        List<Record> randomRecords = new ArrayList<>();
        List<Record> listToRandomize = recordsList;
        if(recordsList.size() < 3) randomRecords = recordsList;
        else {
            Random random = new Random();
            for (int i = 0; i < 3; i++) {
                int randomIndex = random.nextInt(recordsList.size());
                Record record = listToRandomize.get(randomIndex);
                listToRandomize.remove(randomIndex);
                randomRecords.add(record);
            }
        }
        recommendations.setRecommendedByRandom(randomRecords);
    }
}
