package com.aston.componentsystem.service;

import com.aston.componentsystem.dto.WorkCardRequestDTO;
import com.aston.componentsystem.dto.WorkCardResponseDTO;
import com.aston.componentsystem.model.WorkCard;
import com.aston.componentsystem.repository.WorkCardRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkCardService {
    private final WorkCardRepository workCardRepository;
    private final ModelMapper modelMapper;



    public List<WorkCardResponseDTO> getAllWorkCards() {
        List<WorkCard> workCards = workCardRepository.findAll();
        return workCards.stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public WorkCardResponseDTO getWorkCardById(int id) {
        Optional<WorkCard> workCardOptional = workCardRepository.findById(id);
        if (!workCardOptional.isPresent()) {
            throw new NullPointerException();
        }
        WorkCard workCard = workCardOptional.get();
        return convertToResponseDTO(workCard);
    }

    public void saveWorkCard(WorkCardRequestDTO requestDTO) {
        WorkCard workCard = convertToEntity(requestDTO);
        workCardRepository.save(workCard);
    }

    public void deleteWorkCard(int id) {
        Optional<WorkCard> workCardOptional = workCardRepository.findById(id);
        if (!workCardOptional.isPresent()) {
            throw new NullPointerException();
        }
        workCardRepository.deleteById(id);
    }

    private WorkCardResponseDTO convertToResponseDTO(WorkCard workCard) {
        return modelMapper.map(workCard, WorkCardResponseDTO.class);
    }

    private WorkCard convertToEntity(WorkCardRequestDTO requestDTO) {
        return modelMapper.map(requestDTO, WorkCard.class);
    }
}
