package umc.spring.service.RestaurantService;

import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.web.dto.RestaurantRequestDTO;

import java.util.Optional;

public interface RestaurantService {
    Restaurant createRestaurant(RestaurantRequestDTO.CreateDTO request);
    Review createReview(Long memberId, Long restaurantId, RestaurantRequestDTO.CreateReviewDTO request);

    Optional<Restaurant> findRestaurant(Long id);
}
