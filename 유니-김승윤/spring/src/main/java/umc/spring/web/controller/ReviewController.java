package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.service.reviewService.ReviewService;
import umc.spring.web.dto.ReviewDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {
    
    private final ReviewService reviewService;
    
    @PostMapping("/")
    public ApiResponse<String> addReview(@RequestBody @Valid ReviewDTO.ReviewCreateRequestDTO req) {
        reviewService.createReview(req);
        return ApiResponse.onSuccess("리뷰가 생성되었습니다.");
    }
}
