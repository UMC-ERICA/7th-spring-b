package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewDTO;

public class ReviewConverter {
    
    public static Review toReview(ReviewDTO.ReviewCreateRequestDTO req) {
        return Review.builder()
                .content(req.getContent())
                .rating(req.getRating())
                .build();
    }
}
