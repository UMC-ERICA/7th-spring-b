package umc.spring.service.MissionService;

import umc.spring.domain.Mission;

import java.util.List;

public interface MissionQueryService {
    List<Mission> findProgressingMissions(Long memberId);
    List<Mission> findCompletedMissions(Long memberId);
    List<Mission> findAvailableMissions(Long memberId);
}
