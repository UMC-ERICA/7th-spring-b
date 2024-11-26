package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.StoreExists;

public class ReviewDTO {
    
    @Getter
    public static class ReviewCreateRequestDTO {
        
        private Integer rating;
        @NotNull
        private String content;
        @StoreExists
        private Long storeId;
        
    }
}
