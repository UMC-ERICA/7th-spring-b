package umc.spring.web.dto;

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
}
