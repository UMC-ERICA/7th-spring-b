package umc.spring.service.missionService;

import org.springframework.data.domain.Page;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberMissionDto;

public interface MemberMissionService {
    
    boolean isMissionAssignedToMember(Long missionId);
    
    void addMissionToMember(MemberMissionDto.AddMissionToMemberRequestDTO req);
    
    Page<MemberMission> findMissionsByMember(Long memberId, String status, Integer page);
    
    void completeMission(Long memberMissionId);
}