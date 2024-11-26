package umc.spring.web.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class StoreDTO {
    
    @Getter
    public static class StoreToRegion {
        
        @NotNull
        private Long storeId;
        
        @NotNull
        private Long regionId;
        
    }
}
