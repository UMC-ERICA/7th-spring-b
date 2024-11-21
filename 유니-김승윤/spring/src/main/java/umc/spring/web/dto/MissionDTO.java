package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.StoreExists;

public class MissionDTO {
    
    @Getter
    public static class CreateMissionRequestDTO {
        
        @NotNull
        private int point;
        
        @NotNull
        private String missionPrice;
        
        @StoreExists
        private Long storeId;
    }
}
