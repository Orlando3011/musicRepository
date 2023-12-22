package com.pl.musicRepository.controller;

import com.pl.musicRepository.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HistoryController {
    @Autowired
    private HistoryService historyService;

    @GetMapping("/history")
    public String ShowHistoryPage(Model model) {
        model.addAttribute("historyList", historyService.findAllHistory());
        return "history/historyList";
    }

}
