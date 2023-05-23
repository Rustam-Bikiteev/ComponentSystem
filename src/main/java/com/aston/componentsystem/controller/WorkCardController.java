package com.aston.componentsystem.controller;

import com.aston.componentsystem.model.WorkCard;
import com.aston.componentsystem.service.WorkCardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorkCardController {

    public final WorkCardService workCardService;

    public WorkCardController(WorkCardService workCardService) {
        this.workCardService = workCardService;
    }

    @GetMapping("/workCards")
    public List<WorkCard> getAllWorkCards(){
        return workCardService.getAllWorkCards();
    }

    @GetMapping("/workCard/{id}")
    public WorkCard getWorkCardById(@PathVariable int id){
        return workCardService.getWorkCardById(id);
    }

    @PostMapping("/workCard")
    public void saveWorkCard(@RequestBody WorkCard workCard){
        workCardService.saveWorkCard(workCard);
    }

    @DeleteMapping("/workCards/{id}")
    public void deleteWorkCard(@PathVariable int id){
        WorkCard workCard = workCardService.getWorkCardById(id);
        if (workCard != null){
            workCardService.deleteWorkCard(id);
        }

    }
}
