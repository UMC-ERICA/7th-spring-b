package umc.spring.service.RestaurantService;

import umc.spring.domain.Restaurant;
import umc.spring.web.dto.RestaurantRequestDTO;
import umc.spring.web.dto.RestaurantResponseDTO;

public interface RestaurantService {
    Restaurant createRestaurant(RestaurantRequestDTO.CreateDTO request);
}
