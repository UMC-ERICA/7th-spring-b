package umc.spring.repository.RestaurantRepository;

import umc.spring.domain.Restaurant;

import java.util.List;

public interface RestaurantRepositoryCustom {
    List<Restaurant> dynamicQueryWithBooleanBuilder(String name, Float score);
}
