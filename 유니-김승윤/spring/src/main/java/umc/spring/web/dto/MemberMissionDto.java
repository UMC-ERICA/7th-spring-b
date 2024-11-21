package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import umc.spring.validation.annotation.MissionNotAssigned;

import java.time.LocalDateTime;

public class MemberMissionDto {
    
    public static class HomeMissionDto {
        int point;
        String missionPrice;
        String storeName;
        LocalDateTime deadline;
        String missionStatus;
        int count;
    }
    
    public static class MissionSummary {
        private Long totalMissionCount;
        private Long currentMissionCount;
    }
    
    public static class AddMissionToMemberRequestDTO {
        
        @NotNull
        private Long memberId;
        
        @MissionNotAssigned
        private Long missionId;
        
    }
}
