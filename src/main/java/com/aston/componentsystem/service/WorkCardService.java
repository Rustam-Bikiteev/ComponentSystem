package com.aston.componentsystem.service;

import com.aston.componentsystem.model.Aircraft;
import com.aston.componentsystem.model.Component;
import com.aston.componentsystem.model.WorkCard;
import com.aston.componentsystem.repository.AircraftRepository;
import com.aston.componentsystem.repository.ComponentRepository;
import com.aston.componentsystem.repository.WorkCardRepository;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class WorkCardService {

    private final WorkCardRepository workCardRepository;
    private final ComponentRepository componentRepository;
    private final AircraftRepository aircraftRepository;

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

    public void saveWorkCard(@Validated WorkCard workCard,
                             @Parameter(description = "Id Component") Integer componentId,
                             @Parameter(description = "Id Aircraft") Integer aircraftId) {

        Component someComponent = componentRepository.findById(componentId).get();
        Aircraft someAircraft = aircraftRepository.findById(aircraftId).get();

        workCard.setComponent(someComponent);
        workCard.setAircraft(someAircraft);

        workCardRepository.save(workCard);

        log.info("Method name: saveWorkCard {Addition to specific Component} "
            + componentId + " Component "
            + aircraftId + " Aircraft");
    }

    public void deleteWorkCard(int id) {
        Optional<WorkCard> workCardOptional = workCardRepository.findById(id);
        if (workCardOptional.isEmpty()) {
            throw new NullPointerException();
        }
        workCardRepository.deleteById(id);
    }
}
