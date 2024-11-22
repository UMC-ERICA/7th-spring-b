package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.ExistCategory;
import umc.spring.validation.annotation.ExistRegion;

import java.time.LocalDate;

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

    @Getter
    public static class CreateReviewDTO {
        @NotBlank
        String context;
        @NotNull
        Float rating;
    }

    @Getter
    public static class CreateMissionDTO {
        @NotBlank
        String title;
        @NotNull
        String description;
        @NotNull
        Integer point;
        @NotNull
        LocalDate deadline;
    }

}
