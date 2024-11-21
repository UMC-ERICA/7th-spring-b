package umc.spring.service.RestaurantService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.CategoryHandler;
import umc.spring.apiPayload.exception.handler.RegionHandler;
import umc.spring.converter.RestaurantConverter;
import umc.spring.domain.Category;
import umc.spring.domain.Region;
import umc.spring.domain.Restaurant;
import umc.spring.repository.CategoryRepository.CategoryRepository;
import umc.spring.repository.RegionRepository;
import umc.spring.repository.RestaurantRepository.RestaurantRepository;
import umc.spring.web.dto.RestaurantDTO;

@Service
@RequiredArgsConstructor
@Transactional
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final CategoryRepository categoryRepository;
    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public Restaurant createRestaurant(RestaurantDTO.CreateRequestDTO request) {

        Restaurant newRestaurant = RestaurantConverter.toRestaurant(request);

        Category category = categoryRepository.findById(request.getCategory())
                .orElseThrow(() -> new CategoryHandler(ErrorStatus.CATEGORY_NOT_FOUND));
        Region region = regionRepository.findById(request.getRegion())
                .orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));

        newRestaurant.setCategory(category);
        newRestaurant.setRegion(region);

        return restaurantRepository.save(newRestaurant);
    }

}
