package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.web.dto.MissionDTO;

public class MissionConverter {
    
    public static Mission toMission(MissionDTO.CreateMissionRequestDTO req) {
        return Mission.builder()
                .missionPrice(req.getMissionPrice())
                .point(req.getPoint())
                .build();
    }
}
