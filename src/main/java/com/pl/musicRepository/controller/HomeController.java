package com.pl.musicRepository.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String showHomePage() {
        return "layout/home";
    }

    @GetMapping("/")
    public String redirect() {
        return "redirect:/home";
    }
}
