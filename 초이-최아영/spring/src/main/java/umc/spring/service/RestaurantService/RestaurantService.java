package umc.spring.service.RestaurantService;

import umc.spring.domain.Restaurant;
import umc.spring.web.dto.RestaurantDTO;

public interface RestaurantService {
    Restaurant createRestaurant(RestaurantDTO.CreateRequestDTO request);
}
