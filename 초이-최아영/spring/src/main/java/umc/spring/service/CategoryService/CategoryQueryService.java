package umc.spring.service.CategoryService;

import umc.spring.domain.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryQueryService {

    List<Category> findCategoryList(List<Long> categoryList);
    Optional<Category> findCategory(Long id);
}
