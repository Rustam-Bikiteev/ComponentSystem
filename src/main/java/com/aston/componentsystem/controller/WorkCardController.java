package com.aston.componentsystem.controller;

import com.aston.componentsystem.model.WorkCard;
import com.aston.componentsystem.service.WorkCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/workCard{componentId}/{aircraftId}")
    public void saveWorkCard(@RequestBody WorkCard workCard,
                             @PathVariable(name = "componentId") Integer componentId,
                             @PathVariable(name = "aircraftId") Integer aircraftId
    ) {
        workCardService.saveWorkCard(workCard, componentId, aircraftId);
    }

    @DeleteMapping("/workCards/{id}")
    public void deleteWorkCard(@PathVariable int id) {
        workCardService.deleteWorkCard(id);
    }
}
