package com.pl.musicRepository.service;

import com.pl.musicRepository.model.History;
import com.pl.musicRepository.model.Record;
import com.pl.musicRepository.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import java.util.List;

@Service
public class HistoryService {
    @Autowired
    private HistoryRepository historyRepository;

    public List<History> findAllHistory() {
        return historyRepository.findAll();
    }

    public void addRecordToHistory(Record record) {
        History history = new History();
        history.setRecord(record);
        setDateTimeToHistory(history);

        historyRepository.save(history);
    }

    private void setDateTimeToHistory(History history) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy/");
        LocalDateTime now = LocalDateTime.now();
        history.setTimePlayed(dtf.format(now));
    }
}
