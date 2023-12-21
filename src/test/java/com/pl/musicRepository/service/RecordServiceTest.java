package com.pl.musicRepository.service;

import com.pl.musicRepository.model.Record;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class RecordServiceTest {
    @Autowired
    private RecordService recordService;

    @Test
    void findAllRecords() {
        //given
        //when
        recordService.addRecord(RecordServiceTestHelper.createTestRecord());
        recordService.addRecord(RecordServiceTestHelper.createTestRecord());
        recordService.addRecord(RecordServiceTestHelper.createTestRecord());
        //then
        assertEquals(3, recordService.findAllRecords().size());
    }

    @Test
    void addRecord() {
        //given
        recordService.addRecord(RecordServiceTestHelper.createTestRecord());
        //when
        Record record = recordService.findAllRecords().get(0);
        //then
        assertEquals(RecordServiceTestHelper.TEST_NAME, record.getName());
        assertEquals(RecordServiceTestHelper.TEST_ALBUM_NAME, record.getAlbumName());
        assertEquals(RecordServiceTestHelper.TEST_LENGTH, record.getLength());
    }
}