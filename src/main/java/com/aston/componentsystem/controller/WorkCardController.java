package com.aston.componentsystem.controller;

import com.aston.componentsystem.model.WorkCard;
import com.aston.componentsystem.service.WorkCardService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WorkCardController {

    public final WorkCardService workCardService;

    public WorkCardController(WorkCardService workCardService) {
        this.workCardService = workCardService;
    }

    public List<WorkCard> getAllWorkCards(){
        return workCardService.getAllWorkCards();
    }

    public WorkCard getWorkCardById(@PathVariable int id){
        return workCardService.getWorkCardById(id);
    }

    public void saveWorkCard(@RequestBody WorkCard workCard){
        workCardService.saveWorkCard(workCard);
    }

    public void deleteWorkCard(@PathVariable int id){
        WorkCard workCard = workCardService.getWorkCardById(id);
        if (workCard != null){
            workCardService.deleteWorkCard(id);
        }

    }
}
