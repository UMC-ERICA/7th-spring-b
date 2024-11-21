package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.domain.Mission;
import umc.spring.service.missionService.MissionService;
import umc.spring.web.dto.MissionDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {
    
    private final MissionService missionService;
    
    @PostMapping("/")
    public ApiResponse<String> createMission(@RequestBody @Valid MissionDTO.CreateMissionRequestDTO req) {
        missionService.createMission(req);
        
        return ApiResponse.onSuccess("미션 생성됨");
    }
}
