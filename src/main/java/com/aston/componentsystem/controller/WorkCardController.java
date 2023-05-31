package com.aston.componentsystem.controller;

import com.aston.componentsystem.dto.WorkCardRequestDTO;
import com.aston.componentsystem.dto.WorkCardResponseDTO;
import com.aston.componentsystem.service.WorkCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class WorkCardController {

    private final WorkCardService workCardService;

    @GetMapping("/workCards")
    public List<WorkCardResponseDTO> getAllWorkCards() {
        return workCardService.getAllWorkCards();
    }

    @GetMapping("/workCard/{id}")
    public WorkCardResponseDTO getWorkCardById(@PathVariable int id) {
        return workCardService.getWorkCardById(id);
    }

    @PostMapping("/workCard")
    public void saveWorkCard(@RequestBody WorkCardRequestDTO requestDTO) {
        workCardService.saveWorkCard(requestDTO);
    }

    @DeleteMapping("/workCards/{id}")
    public void deleteWorkCard(@PathVariable int id) {
        workCardService.deleteWorkCard(id);
    }
}
