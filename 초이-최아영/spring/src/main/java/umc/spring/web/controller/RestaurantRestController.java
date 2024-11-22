package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.RestaurantConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.service.RestaurantService.RestaurantService;
import umc.spring.validation.annotation.ExistRestaurant;
import umc.spring.web.dto.RestaurantRequestDTO;
import umc.spring.web.dto.RestaurantResponseDTO;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/restaurants")
public class RestaurantRestController {

    private final RestaurantService restaurantService;

    @PostMapping("/")
    public ApiResponse<RestaurantResponseDTO.CreateResultDTO> join(@RequestBody @Valid RestaurantRequestDTO.CreateDTO request) {
        Restaurant restaurant = restaurantService.createRestaurant(request);
        return ApiResponse.onSuccess(RestaurantConverter.toCreateResultDTO(restaurant));
    }

    @PostMapping("{restaurant-id}/reviews")
    public ApiResponse<RestaurantResponseDTO.CreateReviewResultDTO> createReview(@RequestBody @Valid RestaurantRequestDTO.CreateReviewDTO request,
                                                                                 @ExistRestaurant @PathVariable(name = "restaurant-id") Long restaurantId) {
        Review review = restaurantService.createReview(1L, restaurantId, request);
        return ApiResponse.onSuccess(RestaurantConverter.toReviewResult(review));
    }

    @PostMapping("{restaurant-id}/missions")
    public ApiResponse<RestaurantResponseDTO.CreateMissionResultDTO> createMission(@RequestBody @Valid RestaurantRequestDTO.CreateMissionDTO request,
                                                                                   @ExistRestaurant @PathVariable(name = "restaurant-id") Long restaurantId) {
        Mission mission = restaurantService.createMission(restaurantId, request);
        return ApiResponse.onSuccess(RestaurantConverter.toMissionResult(mission));
    }

}
