package com.example.msa_backend.web.dto.food;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

public class FoodWasteRequestDTO {

    @Getter
    @RequiredArgsConstructor
    public static class addDTO {
//        private final Long id;
        private final LocalDate date;
        private final Long wasteAmount;
    }
}
