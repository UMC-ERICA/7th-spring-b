package umc.spring.service.CategoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.domain.Category;
import umc.spring.repository.CategoryRepository.CategoryRepository;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CategoryQueryServiceImpl implements CategoryQueryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> findCategoryList(List<Long> categoryList) {
        return categoryRepository.findAllById(categoryList);
    }

    @Override
    public Optional<Category> findCategory(Long id) {
        return categoryRepository.findById(id);
    }

}
