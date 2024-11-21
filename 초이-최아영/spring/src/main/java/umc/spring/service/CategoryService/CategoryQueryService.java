package umc.spring.service.CategoryService;

import umc.spring.domain.Category;

import java.util.List;

public interface CategoryQueryService {

    List<Category> findCategoryList(List<Long> categoryList);
}
