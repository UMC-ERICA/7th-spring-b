package umc.spring.converter;

import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.web.dto.RestaurantRequestDTO;
import umc.spring.web.dto.RestaurantResponseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class RestaurantConverter {

    public static Restaurant toRestaurant(RestaurantRequestDTO.CreateDTO request) {
        return Restaurant.builder()
                .name(request.getName())
                .build();
    }

    public static RestaurantResponseDTO.CreateResultDTO toCreateResultDTO(Restaurant restaurant) {
        return RestaurantResponseDTO.CreateResultDTO.builder()
                .restaurantId(restaurant.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }


    public static Review toReview(RestaurantRequestDTO.CreateReviewDTO request) {
        return Review.builder()
                .rating(request.getRating())
                .context(request.getContext())
                .date(LocalDate.now())
                .build();
    }

    public static RestaurantResponseDTO.CreateReviewResultDTO toReviewResult(Review review) {
        return RestaurantResponseDTO.CreateReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

}
