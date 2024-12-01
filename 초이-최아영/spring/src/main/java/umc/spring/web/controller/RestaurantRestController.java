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
import umc.spring.converter.RestaurantConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.service.RestaurantService.RestaurantQueryService;
import umc.spring.service.RestaurantService.RestaurantService;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.validation.annotation.ExistRestaurant;
import umc.spring.web.dto.RestaurantRequestDTO;
import umc.spring.web.dto.RestaurantResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/restaurants")
public class RestaurantRestController {

    private final RestaurantService restaurantService;
    private final RestaurantQueryService restaurantQueryService;

    @PostMapping("/")
    public ApiResponse<RestaurantResponseDTO.CreateResultDTO> join(@RequestBody @Valid RestaurantRequestDTO.CreateDTO request) {
        Restaurant restaurant = restaurantService.createRestaurant(request);
        return ApiResponse.onSuccess(RestaurantConverter.toCreateResultDTO(restaurant));
    }

    @PostMapping("{restaurant-id}/reviews")
    public ApiResponse<RestaurantResponseDTO.CreateReviewResultDTO> createReview(@RequestBody @Valid RestaurantRequestDTO.CreateReviewDTO request,
                                                                                 @ExistRestaurant @PathVariable(name = "restaurant-id") Long restaurantId) {
        Review review = restaurantService.createReview(1L, restaurantId, request);
        return ApiResponse.onSuccess(RestaurantConverter.toCreateReviewResult(review));
    }

    @PostMapping("{restaurant-id}/missions")
    public ApiResponse<RestaurantResponseDTO.CreateMissionResultDTO> createMission(@RequestBody @Valid RestaurantRequestDTO.CreateMissionDTO request,
                                                                                   @ExistRestaurant @PathVariable(name = "restaurant-id") Long restaurantId) {
        Mission mission = restaurantService.createMission(restaurantId, request);
        return ApiResponse.onSuccess(RestaurantConverter.toCreateMissionResult(mission));
    }

    @GetMapping("{restaurant-id}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API", description = "특정 가게의 리뷰 목록을 조회하는 API이며, 페이징을 포함합니다. Query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "restaurant-id", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<RestaurantResponseDTO.ReviewPreViewListDTO> getReviewList(@ExistRestaurant @PathVariable(name = "restaurant-id") Long restaurantId, @RequestParam(name = "page") Integer page) {
        Page<Review> reviewList = restaurantQueryService.getReviewList(restaurantId, page);
        return ApiResponse.onSuccess(RestaurantConverter.toReviewPreViewListDTO(reviewList));
    }

    @GetMapping("{restaurant-id}/missions")
    @Operation(summary = "특정 가게의 미션 목록 조회 API", description = "특정 가게의 미션 목록을 조회하는 API이며, 페이징을 포함합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "RESTAURANT4001", description = "가게가 존재하지 않습니다.",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "restaurant-id", description = "가게의 아이디, path variable 입니다."),
            @Parameter(name = "page", description = "페이지 번호, query string 입니다.")
    })
    public ApiResponse<RestaurantResponseDTO.MissionListDTO> getMissionList(@ExistRestaurant @PathVariable(name = "restaurant-id") Long restaurantId,
                                                                            @CheckPage @RequestParam(name = "page") Integer page) {
        page -= 1;
        Page<Mission> missionList = restaurantQueryService.getMissionList(restaurantId, page);
        return ApiResponse.onSuccess(RestaurantConverter.toMissionListDTO(missionList));
    }

}
