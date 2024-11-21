package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import umc.spring.validation.annotation.StoreExists;

public class MissionDTO {
    
    public static class CreateMissionRequestDTO {
        
        @NotNull
        private int point;
        
        @NotNull
        private String missionPrice;
        
        @StoreExists
        private Long storeId;
    }
}
