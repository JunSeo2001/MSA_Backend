package com.example.msa_backend.service.FoodWaste;

import com.example.msa_backend.converter.FoodWasteConverter;
import com.example.msa_backend.domain.FoodWaste;
import com.example.msa_backend.repository.FoodWasteRepository;
import com.example.msa_backend.web.dto.food.FoodWasteRequestDTO;
import com.example.msa_backend.web.dto.food.FoodWasteResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class FoodWasteServiceImpl implements FoodWasteService {

    private final FoodWasteRepository foodWasteRepository;


    @Override
    public FoodWasteResponseDTO.FoodWasteDTO postFoodWaste(FoodWasteRequestDTO.addDTO foodWasteRequestDTO) {

        FoodWaste foodWaste = FoodWasteConverter.toFoodWaste(foodWasteRequestDTO);

        return FoodWasteConverter.toWasteResponseDTO(foodWasteRepository.save(foodWaste));
    }

    @Override
    public List<FoodWasteResponseDTO.FoodWasteDTO> getFoodWastes() {

        LocalDate today = LocalDate.now();
        LocalDate weekAgo = today.minusDays(6); // 오늘 포함 7일

        List<FoodWaste> recentWeek = foodWasteRepository.findAllByDateBetween(weekAgo, today);

        return recentWeek.stream()
                .map(FoodWasteResponseDTO.FoodWasteDTO::toDTO) // DTO로 변환
                .collect(Collectors.toList());
    }
}
