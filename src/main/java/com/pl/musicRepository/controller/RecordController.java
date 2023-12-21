package com.pl.musicRepository.controller;

import com.pl.musicRepository.model.Record;
import com.pl.musicRepository.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RecordController {
    @Autowired
    private RecordService recordService;

    @GetMapping("/records")
    public String ShowProductsPage(Model model) {
        model.addAttribute("recordsList", recordService.findAllRecords());
        return "records/recordsList";
    }


    @GetMapping("/records/deleteRecord/{id}")
    public String deleteRecord(Model model, @PathVariable(name = "id") int id){
        recordService.removeRecord(id);
        model.addAttribute("recordsList", recordService.findAllRecords());
        return "redirect:/records";
    }

    @GetMapping("/records/addRecord")
    public String showAddRecordPage(Model model) {
        model.addAttribute(new Record());
        return "records/addRecord";
    }

    @PostMapping("/records/addRecord")
    public String addRecord(@ModelAttribute Record record, Model model) {
        recordService.addRecordToRepository(record);
        model.addAttribute("recordsList", recordService.findAllRecords());
        return "redirect:/records";
    }

    @GetMapping("/records/editRecord/{id}")
    public String showEditRecordPage(Model model, @PathVariable(name = "id") int id) {
        model.addAttribute(recordService.findRecordById(id));
        return "records/editRecord";
    }

    @PostMapping("/records/editRecord/{id}")
    public String editRecord(Model model, @ModelAttribute Record record) {
        recordService.editRecord(record);
        model.addAttribute("recordsList", recordService.findAllRecords());
        return "redirect:/records";
    }

    @GetMapping("/records/playRecord/{id}")
    public String playRecord(Model model, @PathVariable(name = "id") int id){
        recordService.playRecord(id);
        model.addAttribute("recordsList", recordService.findAllRecords());
        return "redirect:/records";
    }
}
