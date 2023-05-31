package com.aston.componentsystem.service;

import com.aston.componentsystem.dto.AircraftRequestDTO;
import com.aston.componentsystem.dto.AircraftResponseDTO;
import com.aston.componentsystem.model.Aircraft;
import com.aston.componentsystem.repository.AircraftRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AircraftService {

    private final AircraftRepository aircraftRepository;
    private final ModelMapper modelMapper;



    public List<AircraftResponseDTO> getAllAircraft() {
        List<Aircraft> aircraftList = aircraftRepository.findAll();
        return aircraftList.stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public AircraftResponseDTO getAircraftById(int id) {
        Optional<Aircraft> aircraftOptional = aircraftRepository.findById(id);
        if (!aircraftOptional.isPresent()) {
            throw new NullPointerException();
        }
        return convertToResponseDTO(aircraftOptional.get());
    }

    public void saveAircraft(AircraftRequestDTO aircraftRequestDTO) {
        Aircraft aircraft = convertToEntity(aircraftRequestDTO);
        aircraftRepository.save(aircraft);
    }

    public void deleteAircraft(int id) {
        Optional<Aircraft> aircraft = aircraftRepository.findById(id);
        if (!aircraft.isPresent()) {
            throw new NullPointerException();
        }
        aircraftRepository.deleteById(id);
    }

    private AircraftResponseDTO convertToResponseDTO(Aircraft aircraft) {
        return modelMapper.map(aircraft, AircraftResponseDTO.class);
    }

    private Aircraft convertToEntity(AircraftRequestDTO aircraftRequestDTO) {
        return modelMapper.map(aircraftRequestDTO, Aircraft.class);
    }
}
