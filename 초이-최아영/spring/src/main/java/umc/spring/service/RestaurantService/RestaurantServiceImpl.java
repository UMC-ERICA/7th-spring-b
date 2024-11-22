package umc.spring.service.RestaurantService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.CategoryHandler;
import umc.spring.apiPayload.exception.handler.MemberHandler;
import umc.spring.apiPayload.exception.handler.RegionHandler;
import umc.spring.apiPayload.exception.handler.RestaurantHandler;
import umc.spring.converter.RestaurantConverter;
import umc.spring.domain.*;
import umc.spring.repository.CategoryRepository.CategoryRepository;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.repository.RegionRepository;
import umc.spring.repository.RestaurantRepository.RestaurantRepository;
import umc.spring.repository.ReviewRepository;
import umc.spring.web.dto.RestaurantRequestDTO;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final CategoryRepository categoryRepository;
    private final RegionRepository regionRepository;
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Restaurant createRestaurant(RestaurantRequestDTO.CreateDTO request) {

        Restaurant newRestaurant = RestaurantConverter.toRestaurant(request);

        Category category = categoryRepository.findById(request.getCategory())
                .orElseThrow(() -> new CategoryHandler(ErrorStatus.CATEGORY_NOT_FOUND));
        Region region = regionRepository.findById(request.getRegion())
                .orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));

        newRestaurant.setCategory(category);
        newRestaurant.setRegion(region);

        return restaurantRepository.save(newRestaurant);
    }

    @Override
    @Transactional
    public Review createReview(Long memberId, Long restaurantId, RestaurantRequestDTO.CreateReviewDTO request) {

        Review newReview = RestaurantConverter.toReview(request);

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RestaurantHandler(ErrorStatus.RESTAURANT_NOT_FOUND));

        newReview.setMember(member);
        newReview.setRestaurant(restaurant);

        return reviewRepository.save(newReview);
    }

    @Override
    public Optional<Restaurant> findRestaurant(Long id) {
        return restaurantRepository.findById(id);
    }

}
