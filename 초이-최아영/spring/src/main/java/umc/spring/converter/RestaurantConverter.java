package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.web.dto.RestaurantRequestDTO;
import umc.spring.web.dto.RestaurantResponseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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
    public static RestaurantResponseDTO.CreateReviewResultDTO toCreateReviewResult(Review review) {
        return RestaurantResponseDTO.CreateReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }


    public static Mission toMission(RestaurantRequestDTO.CreateMissionDTO request) {
        return Mission.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .point(request.getPoint())
                .deadline(request.getDeadline())
                .build();
    }
    public static RestaurantResponseDTO.CreateMissionResultDTO toCreateMissionResult(Mission mission) {
        return RestaurantResponseDTO.CreateMissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }


    public static RestaurantResponseDTO.ReviewPreViewDTO toReviewPreViewDTO(Review review){
        return RestaurantResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getRating())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getContext())
                .build();
    }
    public static RestaurantResponseDTO.ReviewPreViewListDTO toReviewPreViewListDTO(Page<Review> reviewList){

        List<RestaurantResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(RestaurantConverter::toReviewPreViewDTO).collect(Collectors.toList());

        return RestaurantResponseDTO.ReviewPreViewListDTO.builder()
                .isFirst(reviewList.isFirst())
                .isLast(reviewList.isLast())
                .totalPages(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }

}
