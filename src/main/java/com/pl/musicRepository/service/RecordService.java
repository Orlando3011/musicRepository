package com.pl.musicRepository.service;

import com.pl.musicRepository.model.Record;
import com.pl.musicRepository.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {
    @Autowired
    private RecordRepository records;
    @Autowired
    private HistoryService historyService;

    public List<Record> findAllRecords() {
        return records.findAll();
    }

    public void addRecord(Record record) {
        records.save(record);
    }

    public void removeRecord(int id) {
        if(records.findById(id).isPresent())
            records.delete(records.findById(id).get());
    }

    public Record findRecordById(int id) {
        if(records.findById(id).isPresent())
            return records.findById(id).get();
        else return null;
    }

    public void editRecord(Record record) {
        record.setPlaybacks(0);
        records.save(record);
    }

    public void addRecordToRepository(Record record) {
        record.setPlaybacks(0);
        records.save(record);
    }

    public Record playRecord(int id) {
        if(records.findById(id).isPresent()) {
            Record record = records.findById(id).get();
            if(record.getPlaybacks() == null) record.setPlaybacks(0);
            record.setPlaybacks(record.getPlaybacks() + 1);

            records.save(record);
            historyService.addRecordToHistory(record);

            return record;
        }
        else return null;
    }
}
