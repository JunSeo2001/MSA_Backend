package com.example.msa_backend.web.dto.food;

import com.example.msa_backend.domain.FoodWaste;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Getter
public class FoodWasteResponseDTO {

    @Getter
    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    @Builder(access = AccessLevel.PRIVATE)
    public static class FoodWasteDTO {
        private final Long id;
        private final LocalDate date;
        private final Long wasteAmount;

        public static FoodWasteDTO toDTO(FoodWaste waste) {
            return FoodWasteDTO.builder()
                    .id(waste.getId())
                    .date(waste.getDate())
                    .wasteAmount(waste.getWasteAmount())
                    .build();
        }
    }
}
