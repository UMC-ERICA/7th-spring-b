package umc.spring.repository.MemberMissionRepository;

import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberMissionDto;

import java.util.List;

public interface MemberMissionRepositoryCustom {
    List<MemberMission> findMemberMissions(Long memberId);
    
    MemberMissionDto.MissionSummary getMissionSummary(Long memberId);
    
    List<MemberMissionDto.HomeMissionDto> findMissionInfo(Long memberId);
}
