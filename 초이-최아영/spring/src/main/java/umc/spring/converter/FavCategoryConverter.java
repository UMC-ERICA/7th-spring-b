package umc.spring.converter;

import umc.spring.domain.Category;
import umc.spring.domain.mapping.FavCategory;

import java.util.List;
import java.util.stream.Collectors;

public class FavCategoryConverter {

    public static List<FavCategory> toFavCategoryList(List<Category> categoryList) {

        return categoryList.stream()
                .map(category ->
                        FavCategory.builder()
                                .category(category)
                                .build()
                ).collect(Collectors.toList());
    }
}
