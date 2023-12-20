package com.pl.musicRepository.controller;

import com.pl.musicRepository.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RecordController {
    @Autowired
    private RecordService recordService;
}
