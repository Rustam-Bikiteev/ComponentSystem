package com.aston.componentsystem.controller;

import com.aston.componentsystem.model.WorkCard;
import com.aston.componentsystem.service.WorkCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WorkCardController {

    public final WorkCardService workCardService;

    @GetMapping("/workCards")
    public List<WorkCard> getAllWorkCards() {
        return workCardService.getAllWorkCards();
    }

    @GetMapping("/workCard/{id}")
    public WorkCard getWorkCardById(@PathVariable int id) {
        return workCardService.getWorkCardById(id);
    }

    @PostMapping("/workCard")
    public void saveWorkCard(@RequestBody WorkCard workCard) {
        workCardService.saveWorkCard(workCard);
    }

    @DeleteMapping("/workCards/{id}")
    public void deleteWorkCard(@PathVariable int id) {
        workCardService.deleteWorkCard(id);
    }
}