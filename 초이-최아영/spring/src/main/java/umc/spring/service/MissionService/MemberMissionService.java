package umc.spring.service.MissionService;

import umc.spring.domain.mapping.MemberMission;

import java.util.Optional;

public interface MemberMissionService {

    Optional<MemberMission> findMemberMission(Long memberId, Long missionId);
}
