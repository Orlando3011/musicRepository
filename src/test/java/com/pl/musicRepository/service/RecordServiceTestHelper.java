package com.pl.musicRepository.service;

import com.pl.musicRepository.model.Record;

public class RecordServiceTestHelper {

    public static final String TEST_NAME = "testName";
    public static final String TEST_ALBUM_NAME = "testAlbumName";
    public static final String TEST_AUTHOR = "testAuthor";
    public static final String TEST_GENRE = "testGenre";

    public static Record createTestRecord() {
        Record record = new Record();

        record.setName(TEST_NAME);
        record.setAlbumName(TEST_ALBUM_NAME);
        record.setAuthor(TEST_AUTHOR);
        record.setGenre(TEST_GENRE);
        return record;
    }
}
