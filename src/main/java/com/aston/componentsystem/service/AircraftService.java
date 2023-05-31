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
        if (!aircraftOptional.isPresent()) {
            throw new NullPointerException();
        }
        return aircraftOptional.get();
    }

    public void saveAircraft(Aircraft aircraft) {
        Aircraft creatingAircraft = new Aircraft();
        creatingAircraft.setSerialNumber(aircraft.getSerialNumber());
        creatingAircraft.setRegNumber(aircraft.getRegNumber());
        creatingAircraft.setDescription(aircraft.getDescription());
        creatingAircraft.setModel(aircraft.getModel());
        creatingAircraft.setOperating(aircraft.isOperating());
        creatingAircraft.setComponents(aircraft.getComponents());
        aircraftRepository.save(creatingAircraft);
    }

    public void deleteAircraft(int id) {
        Optional<Aircraft> aircraft = aircraftRepository.findById(id);
        if (!aircraft.isPresent()) {
            throw new NullPointerException();
        }
        aircraftRepository.deleteById(id);
    }
}
