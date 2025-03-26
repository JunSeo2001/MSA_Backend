package com.example.msa_backend.web.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/foodWaste")
@RequiredArgsConstructor
public class FoodWasteController {
    private final foodWasteService FoodWasteService;

    @PostMapping("/trash")
    public ApiResponse<AdminResponseDTO.DeletedMemberListDTO> deleteInactiveMembers() {
        // 관리자 인증
        if (!adminService.getIsAdmin()) {
            throw new GeneralException(ErrorStatus._NOT_ADMIN);
        }
        AdminResponseDTO.DeletedMemberListDTO deletedMemberListDTO = adminService.deleteInactiveMembers();
        return ApiResponse.onSuccess(SuccessStatus._MEMBER_DELETED, deletedMemberListDTO);
    }
}
