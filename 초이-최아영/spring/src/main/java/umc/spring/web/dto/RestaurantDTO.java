package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.validation.annotation.ExistRegion;

import java.time.LocalDateTime;

public class RestaurantDTO {

    @Getter
    public static class CreateRequestDTO {
        @NotBlank
        String name;
        @NotNull
        Long category;
        @ExistRegion
        Long region;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateResponseDTO {
        Long restaurantId;
        LocalDateTime createdAt;
    }

}

