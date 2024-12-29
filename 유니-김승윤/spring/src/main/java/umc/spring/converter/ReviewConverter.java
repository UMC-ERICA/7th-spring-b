package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewDTO;
import umc.spring.web.dto.ReviewResponseDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {
    
    public static Review toReview(ReviewDTO.ReviewCreateRequestDTO req) {
        return Review.builder()
                .content(req.getContent())
                .rating(req.getRating())
                .build();
    }
    
    public static ReviewResponseDTO.MyReviewDTO toMyReviewDTO(Review review) {
        return ReviewResponseDTO.MyReviewDTO.builder()
                .content(review.getContent())
                .rating(review.getRating())
                .createdAt(LocalDate.now())
                .ownerNickname(review.getMember().getNickname())
                .build();
    
    }
    
    public static ReviewResponseDTO.MyReviewListDTO toMyReviewListDTO(Page<Review> reviews) {
        List<ReviewResponseDTO.MyReviewDTO> reviewDTOS = reviews.stream()
                .map(ReviewConverter::toMyReviewDTO).collect(Collectors.toList());
        
        return ReviewResponseDTO.MyReviewListDTO.builder()
                .reviewList(reviewDTOS)
                .listSize(reviewDTOS.size())
                .totalElements(reviews.getTotalElements())
                .isFirst(reviews.isFirst())
                .isLast(reviews.isLast())
                .totalPage(reviews.getTotalPages())
                .build();
    }
    
}
