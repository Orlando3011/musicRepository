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

    public List<Record> findAllRecords() {
        return records.findAll();
    }

    public void addRecord(Record record) {
        records.save(record);
    }


}
