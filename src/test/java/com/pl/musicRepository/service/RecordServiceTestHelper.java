package com.pl.musicRepository.service;

import com.pl.musicRepository.model.Record;

public class RecordServiceTestHelper {

    public static final String TEST_NAME = "testName";
    public static final String TEST_ALBUM_NAME = "testAlbumName";
    public static final String TEST_LENGTH = "3:00";

    public static Record createTestRecord() {
        Record record = new Record();

        record.setName(TEST_NAME);
        record.setAlbumName(TEST_ALBUM_NAME);
        record.setLength(TEST_LENGTH);
        return record;
    }
}
