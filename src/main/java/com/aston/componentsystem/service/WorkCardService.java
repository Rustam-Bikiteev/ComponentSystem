package com.aston.componentsystem.service;

import com.aston.componentsystem.model.WorkCard;
import com.aston.componentsystem.repository.WorkCardRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WorkCardService {
    private final WorkCardRepository workCardRepository;

    public WorkCardService(WorkCardRepository workCardRepository) {
        this.workCardRepository = workCardRepository;
    }

    public List<WorkCard> getAllWorkCards() {
        return workCardRepository.findAll();
    }

    public WorkCard getWorkCardById(int id) {
        Optional<WorkCard> workCardOptional = workCardRepository.findById(id);
        if (!workCardOptional.isPresent()) {
            throw new NullPointerException();
        }
        return workCardOptional.get();
    }

    public void saveWorkCard(WorkCard workCard) {
       workCardRepository.save(workCard);
    }

    public void deleteWorkCard(int id) {
        Optional<WorkCard> workCardOptional = workCardRepository.findById(id);
        if (!workCardOptional.isPresent()) {
            throw new NullPointerException();
        }
        workCardRepository.deleteById(id);
    }
}