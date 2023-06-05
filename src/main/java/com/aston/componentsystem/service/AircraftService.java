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
        Iterable<Aircraft> aircraftIterable = aircraftRepository.findAll();
        List<Aircraft> aircraftList = new ArrayList<>();
        for (Aircraft aircraft : aircraftIterable) {
            aircraftList.add(aircraft);
        }
        return aircraftList;
    }

    public Aircraft getAircraftById(int id) {
        Optional<Aircraft> aircraftOptional = aircraftRepository.findById(id);
        if (aircraftOptional.isEmpty()) {
            throw new NullPointerException();
        }
        return aircraftOptional.get();
    }

    public void saveAircraft(Aircraft aircraft) {
        aircraftRepository.save(aircraft);
    }

    public void deleteAircraft(int id) {
        Optional<Aircraft> aircraft = aircraftRepository.findById(id);
        if (aircraft.isEmpty()) {
            throw new NullPointerException();
        }
        aircraftRepository.deleteById(id);
    }
}
