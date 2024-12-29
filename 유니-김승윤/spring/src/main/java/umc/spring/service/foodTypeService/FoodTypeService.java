package umc.spring.service.foodTypeService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.domain.FoodType;
import umc.spring.repository.FoodTypeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class FoodTypeService {

    private final FoodTypeRepository foodTypeRepository;

    public boolean areCategoriesValid(List<Long> categoryIds) {
        if (categoryIds == null || categoryIds.isEmpty()) {
            return true; // null 또는 빈 리스트는 유효한 것으로 처리
        }

        // Repository를 한 번 호출하여 검증
        List<Long> existingTypeIds = foodTypeRepository.findAllById(categoryIds)
                .stream()
                .map(FoodType::getId)
                .toList();

        return categoryIds.stream().allMatch(existingTypeIds::contains);
    }
}