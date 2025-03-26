package com.example.msa_backend.web.controller;


import com.example.msa_backend.service.FoodWaste.FoodWasteService;
import com.example.msa_backend.web.dto.food.FoodWasteRequestDTO;
import com.example.msa_backend.web.dto.food.FoodWasteResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/foodWaste")
@RequiredArgsConstructor
public class FoodWasteController {
    private final FoodWasteService foodWasteService;

    @PostMapping("/trash")
    public FoodWasteResponseDTO.FoodWasteDTO postWaste (
            @RequestBody FoodWasteRequestDTO.addDTO foodWasteDTO
    ) {
        return foodWasteService.postFoodWaste(foodWasteDTO);
    }

    @GetMapping("/data")
    public List<FoodWasteResponseDTO.FoodWasteDTO> getWaste (
//            @RequestBody FoodWasteRequestDTO.addDTO foodWasteDTO
    ) {

        return foodWasteService.getFoodWastes();
    }
}
