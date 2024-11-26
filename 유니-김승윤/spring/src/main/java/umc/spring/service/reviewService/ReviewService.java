package umc.spring.service.reviewService;

import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewDTO;

public interface ReviewService {
    
    void createReview(ReviewDTO.ReviewCreateRequestDTO req);
}
