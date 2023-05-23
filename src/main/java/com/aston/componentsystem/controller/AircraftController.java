package com.aston.componentsystem.controller;

import com.aston.componentsystem.service.AircraftService;
import com.aston.componentsystem.model.Aircraft;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AircraftController {

    public final AircraftService aircraftService;

    public AircraftController(AircraftService aircraftService) {
        this.aircraftService = aircraftService;
    }

    @GetMapping("/aircraft")
    public List<Aircraft> getAllAircraft() {
        return aircraftService.getAllAircraft();
    }

    @GetMapping("/aircraft/{id}")
    public Aircraft getAircraftById(@PathVariable int id) {
        return aircraftService.getAircraftById(id);
    }

    @PostMapping("/aircraft")
    public void saveAircraft(@RequestBody Aircraft aircraft) {
        aircraftService.saveAircraft(aircraft);
    }

    @DeleteMapping("/aircrafts/{id}")
    public void deleteAircraft(@PathVariable int id){
        Aircraft aircraft = aircraftService.getAircraftById(id);
        if (aircraft != null) {
            aircraftService.deleteAircraft(id);
        }
    }
}
