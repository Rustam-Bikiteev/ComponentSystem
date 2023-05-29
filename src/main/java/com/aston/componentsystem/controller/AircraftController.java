package com.aston.componentsystem.controller;

import com.aston.componentsystem.service.AircraftService;
import com.aston.componentsystem.model.Aircraft;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AircraftController {

    public final AircraftService aircraftService;

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
    public void deleteAircraft(@PathVariable int id) {
        aircraftService.deleteAircraft(id);
    }
}
