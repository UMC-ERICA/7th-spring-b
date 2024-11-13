package umc.spring.repository.MissionRepository;

import umc.spring.domain.Mission;
import umc.spring.web.dto.MissionStatusDto;

import java.util.List;

public interface MissionRepositoryCustom {

    List<MissionStatusDto> findProgressingMissionsByMemberId(Long memberId);
    List<MissionStatusDto> findCompletedMissionsByMemberId(Long memberId);
    List<Mission> findAvailableMissionsByMemberId(Long memberId);

}
