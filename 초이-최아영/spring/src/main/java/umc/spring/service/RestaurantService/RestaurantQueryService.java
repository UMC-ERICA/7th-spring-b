package umc.spring.service.RestaurantService;

import umc.spring.domain.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantQueryService {

    Optional<Restaurant> findRestaurant(Long id);
    List<Restaurant> findRestaurantsByNameAndScore(String name, Float score);

}
