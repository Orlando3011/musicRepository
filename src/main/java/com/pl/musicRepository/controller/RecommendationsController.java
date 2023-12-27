package com.pl.musicRepository.controller;

import com.pl.musicRepository.service.RecommendationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecommendationsController {
    @Autowired
    RecommendationsService recommendationsService;

    @GetMapping("/recommendations")
    public String ShowRecommendationsPage(Model model) {
        model.addAttribute("Recommendations", recommendationsService.createRecommendations());
        return "recommendations/recommendationsPage";
    }
}
