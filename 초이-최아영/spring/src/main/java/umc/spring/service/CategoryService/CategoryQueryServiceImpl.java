package umc.spring.service.CategoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.domain.Category;
import umc.spring.repository.CategoryRepository.CategoryRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CategoryQueryServiceImpl implements CategoryQueryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> findCategoryList(List<Long> categoryList) {

        return categoryRepository.findAllById(categoryList);
    }

}
