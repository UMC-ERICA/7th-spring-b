package umc.spring.repository.MissionRepository;

import umc.spring.domain.Mission;

import java.util.List;

public interface MissionRepositoryCustom {

    List<Mission> findProgressingMissionsByMemberId(Long memberId);
    List<Mission> findCompletedMissionsByMemberId(Long memberId);
    List<Mission> findAvailableMissionsByMemberId(Long memberId);
}
