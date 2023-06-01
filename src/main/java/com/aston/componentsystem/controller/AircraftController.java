package com.aston.componentsystem.controller;

import com.aston.componentsystem.dto.AircraftRequestDTO;
import com.aston.componentsystem.dto.AircraftResponseDTO;
import com.aston.componentsystem.service.AircraftService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AircraftController {

    private final AircraftService aircraftService;

    @GetMapping("/aircraft")
    public List<AircraftResponseDTO> getAllAircraft() {
        return aircraftService.getAllAircraft();
    }

    @GetMapping("/aircraft/{id}")
    public AircraftResponseDTO getAircraftById(@PathVariable int id) {
        return aircraftService.getAircraftById(id);
    }

    @PostMapping("/aircraft")
    public void saveAircraft(@RequestBody AircraftRequestDTO aircraftRequestDTO) {
        aircraftService.saveAircraft(aircraftRequestDTO);
    }

    @DeleteMapping("/aircraft/{id}")
    public void deleteAircraft(@PathVariable int id) {
        aircraftService.deleteAircraft(id);
    }
}
