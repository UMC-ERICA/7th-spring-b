package umc.spring.service.missionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.repository.MemberMissionRepository.MemberMissionRepository;

@Service
@RequiredArgsConstructor
public class MemberMissionService {

    private final MemberMissionRepository memberMissionRepository;

    /**
     * 미션이 회원 미션에 이미 존재하는지 확인
     */
    public boolean isMissionAssignedToMember(Long missionId) {
        return memberMissionRepository.existsByMissionId(missionId);
    }
}