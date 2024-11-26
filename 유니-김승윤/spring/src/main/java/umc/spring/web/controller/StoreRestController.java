package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.service.storeService.StoreService;
import umc.spring.web.dto.StoreDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {
    private final StoreService storeService;
    
    @PostMapping("/regions")
    public ApiResponse<String> addRegionToStore(@RequestBody @Valid StoreDTO.StoreToRegion req) {
        storeService.addStoreToRegion(req);
        return ApiResponse.onSuccess("성공하였습니다.");
    }
}
