package umc.spring.service.reviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.MemberHandler;
import umc.spring.apiPayload.exception.handler.StoreHandler;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.repository.ReviewRepository;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.web.dto.ReviewDTO;


@Service
@RequiredArgsConstructor
@Transactional
public class ReviewServiceImpl implements ReviewService {
    
    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;
    
    @Override
    public void createReview(ReviewDTO.ReviewCreateRequestDTO req) {
        
        Store findStore = storeRepository.findById(req.getStoreId()).orElseThrow(
                () -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND)
        );
        Member findMember = memberRepository.findById(1L).orElseThrow(
                () -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND)
        );
        Review review = ReviewConverter.toReview(req);
        review.setStore(findStore);
        review.setMember(findMember);
        
        reviewRepository.save(review);
    }
    
    @Override
    public Page<Review> getReviews(Long memberId, Integer page) {
        
        Member findMember = memberRepository.findById(memberId).get();
        
        Page<Review> memberPage = reviewRepository.findAllByMember(findMember, PageRequest.of(page, 10));
        
        return memberPage;
    }
}
