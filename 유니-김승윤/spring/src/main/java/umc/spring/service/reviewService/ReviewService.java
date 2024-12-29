package umc.spring.service.reviewService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewDTO;

public interface ReviewService {
    
    void createReview(ReviewDTO.ReviewCreateRequestDTO req);
    
    Page<Review> getReviews(Long memberId, Integer page);
    
}
