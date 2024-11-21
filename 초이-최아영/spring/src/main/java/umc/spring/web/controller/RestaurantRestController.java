package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.RestaurantConverter;
import umc.spring.domain.Restaurant;
import umc.spring.service.RestaurantService.RestaurantService;
import umc.spring.web.dto.RestaurantDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurants")
public class RestaurantRestController {

    private final RestaurantService restaurantService;

    @PostMapping("/")
    public ApiResponse<RestaurantDTO.CreateResponseDTO> join(@RequestBody @Valid RestaurantDTO.CreateRequestDTO request) {
        Restaurant restaurant = restaurantService.createRestaurant(request);
        return ApiResponse.onSuccess(RestaurantConverter.toCreateResponseDTO(restaurant));
    }

}
