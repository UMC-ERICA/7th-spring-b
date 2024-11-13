package umc.spring.service.MissionService;

import umc.spring.domain.Mission;
import umc.spring.web.dto.MissionStatusDto;

import java.util.List;

public interface MissionQueryService {
    List<MissionStatusDto> findProgressingMissions(Long memberId);
    List<MissionStatusDto> findCompletedMissions(Long memberId);
    List<Mission> findAvailableMissions(Long memberId);
}
