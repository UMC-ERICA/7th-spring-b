package umc.spring.service.missionService;

import umc.spring.web.dto.MissionDTO;

public interface MissionService {
    
    void createMission(MissionDTO.CreateMissionRequestDTO req);
}
