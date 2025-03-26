package com.example.msa_backend.converter;

import com.example.msa_backend.domain.FoodWaste;
import com.example.msa_backend.web.dto.food.FoodWasteRequestDTO;
import com.example.msa_backend.web.dto.food.FoodWasteResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class FoodWasteConverter {

    public static FoodWasteResponseDTO.FoodWasteDTO toWasteResponseDTO(FoodWaste foodWaste) {
        return FoodWasteResponseDTO.FoodWasteDTO.toDTO(foodWaste);
    }

    public static FoodWaste toFoodWaste(FoodWasteRequestDTO.addDTO foodWasteDTO) {
        return FoodWaste.builder()
                .date(foodWasteDTO.getDate())
                .wasteAmount(foodWasteDTO.getWasteAmount())
                .build();
    }
}
