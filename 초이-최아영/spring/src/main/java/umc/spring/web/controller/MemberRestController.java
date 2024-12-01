package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MemberService.MemberCommandService;
import umc.spring.service.MemberService.MemberQueryService;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.validation.annotation.ExistMember;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.MemberResponseDTO;


@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request) {
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @PostMapping("missions")
    public ApiResponse<MemberResponseDTO.ChallengeMissionResultDTO> challengeMission(@RequestBody @Valid MemberRequestDTO.ChallengeMissionDTO request) {
        MemberMission memberMission = memberCommandService.challengeMission(request);
        return ApiResponse.onSuccess(MemberConverter.toChallengeMissionResultDTO(memberMission));
    }

    @GetMapping("{member-id}/reviews")
    @Operation(summary = "내가 작성한 리뷰 목록 조회 API", description = "내가 작성한 리뷰 목록을 조회하는 API이며, 페이징을 포함합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "member-id", description = "유저의 아이디, path variable 입니다."),
            @Parameter(name = "page", description = "페이지 번호, query string 입니다.")
    })
    public ApiResponse<MemberResponseDTO.MyReviewListDTO> getReviewList(@ExistMember @PathVariable(name = "member-id") Long memberId,
                                                                        @CheckPage @RequestParam(name = "page") Integer page) {
        page -= 1;
        Page<Review> reviewList = memberQueryService.getReviewList(memberId, page);
        return ApiResponse.onSuccess(MemberConverter.toMyReviewListDTO(reviewList));
    }

    @GetMapping("{member-id}/missions/challenging")
    @Operation(summary = "내가 진행 중인 미션 목록 조회 API", description = "내가 진행 중인 미션 목록을 조회하는 API이며, 페이징을 포함합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "MEMBER4001", description = "사용자가 없습니다.",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "PAGE4001", description = "잘못된 페이지 요청입니다.",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "member-id", description = "유저의 아이디, path variable 입니다."),
            @Parameter(name = "page", description = "페이지 번호, query string 입니다.")
    })
    public ApiResponse<MemberResponseDTO.MyMissionListDTO> getChallengingMissionList(@ExistMember @PathVariable(name = "member-id") Long memberId,
                                                                                     @CheckPage @RequestParam(name = "page") Integer page) {
        page -= 1;
        Page<Mission> missionList = memberQueryService.getChallengingMissionList(memberId, page);
        return ApiResponse.onSuccess(MemberConverter.toMyMissionListDTO(missionList));
    }


}
