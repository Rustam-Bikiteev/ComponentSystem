package com.aston.componentsystem.service;

import com.aston.componentsystem.model.Aircraft;
import com.aston.componentsystem.repository.AircraftRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AircraftService {

    private final AircraftRepository aircraftRepository;

    public AircraftService(AircraftRepository aircraftRepository) {
        this.aircraftRepository = aircraftRepository;
    }

    public List<Aircraft> getAllAircraft() {
        return aircraftRepository.findAll();
    }

    public Aircraft getAircraftById(int id) {
        Optional<Aircraft> aircraftOptional = aircraftRepository.findById(id);
        if (!aircraftOptional.isPresent()) {
            throw new NullPointerException();
        }
        return aircraftOptional.get();
    }

    public void saveAircraft(Aircraft aircraft) {
        aircraftRepository.save(aircraft);
    }

    public void deleteAircraft(int id) {
        Optional<Aircraft> aircraft = aircraftRepository.findById(id);
        if (!aircraft.isPresent()) {
            throw new NullPointerException();
        }
        aircraftRepository.deleteById(id);
    }
}
