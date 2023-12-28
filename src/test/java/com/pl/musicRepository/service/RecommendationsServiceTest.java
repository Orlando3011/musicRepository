package com.pl.musicRepository.service;

import com.pl.musicRepository.model.Recommendations;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class RecommendationsServiceTest {

    @Autowired
    private HistoryService historyService;
    @Autowired
    private RecordService recordService;
    @Autowired
    private RecommendationsService recommendationsService;

    @Test
    public void prepareFavouriteGenre() {
        //given
        //when

        recordService.addRecord(RecordServiceTestHelper.createTestRecord());
        historyService.addRecordToHistory(recordService.findAllRecords().get(0));
        Recommendations recommendations = recommendationsService.createRecommendations();
        //then

    }
}