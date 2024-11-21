package umc.spring.converter;

import umc.spring.domain.Restaurant;
import umc.spring.web.dto.RestaurantDTO;

import java.time.LocalDateTime;

public class RestaurantConverter {

    public static RestaurantDTO.CreateResponseDTO toCreateResponseDTO(Restaurant restaurant) {
        return RestaurantDTO.CreateResponseDTO.builder()
                .restaurantId(restaurant.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Restaurant toRestaurant(RestaurantDTO.CreateRequestDTO request) {
        return Restaurant.builder()
                .name(request.getName())
                .build();
    }

}
