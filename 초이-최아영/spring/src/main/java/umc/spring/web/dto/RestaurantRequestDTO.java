package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import umc.spring.validation.annotation.ExistCategory;
import umc.spring.validation.annotation.ExistRegion;

public class RestaurantRequestDTO {

    @Getter
    public static class CreateDTO {
        @NotBlank
        String name;
        @ExistCategory
        Long category;
        @ExistRegion
        Long region;
    }
}
