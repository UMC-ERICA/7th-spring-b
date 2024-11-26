package umc.spring.service.missionService;

import umc.spring.web.dto.MemberMissionDto;

public interface MemberMissionService {
    
    boolean isMissionAssignedToMember(Long missionId);
    
    void addMissionToMember(MemberMissionDto.AddMissionToMemberRequestDTO req);
}