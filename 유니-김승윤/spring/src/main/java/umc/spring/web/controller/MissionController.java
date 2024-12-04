package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.missionService.MemberMissionService;
import umc.spring.service.missionService.MissionService;
import umc.spring.web.dto.MemberMissionDto;
import umc.spring.web.dto.MissionDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {
    
    private final MissionService missionService;
    private final MemberMissionService memberMissionService;
    
    @PostMapping("/")
    public ApiResponse<String> createMission(@RequestBody @Valid MissionDTO.CreateMissionRequestDTO req) {
        missionService.createMission(req);
        
        return ApiResponse.onSuccess("미션 생성됨");
    }
    
    @PostMapping("/challenge")
    public ApiResponse<String> challengeMission(@RequestBody @Valid MemberMissionDto.AddMissionToMemberRequestDTO req) {
        memberMissionService.addMissionToMember(req);
        
        return ApiResponse.onSuccess("미션 도전하기 추가 완료");
    }
    
    @PatchMapping("/{memberMissionId}/complete")
    @Operation(summary = "미션 진행 완료 API", description = "진행 중인 미션을 완료 상태로 변경합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON404", description = "NOT FOUND, 엔티티를 찾을 수 없음"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON400", description = "BAD REQUEST, 잘못된 요청")
    })
    @Parameters({
            @Parameter(name = "memberMissionId", description = "회원 미션의 ID")
    })
    public ApiResponse<String> completeMission(@PathVariable Long memberMissionId) {
        memberMissionService.completeMission(memberMissionId);
        return ApiResponse.onSuccess("미션 성공");
    }
}
