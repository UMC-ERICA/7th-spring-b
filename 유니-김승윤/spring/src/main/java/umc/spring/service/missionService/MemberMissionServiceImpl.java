package umc.spring.service.missionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.MemberHandler;
import umc.spring.apiPayload.exception.handler.MissionHandler;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository.MemberMissionRepository;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.web.dto.MemberMissionDto;

@Service
@RequiredArgsConstructor
public class MemberMissionServiceImpl implements MemberMissionService {

    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    

    @Override
    public boolean isMissionAssignedToMember(Long missionId) {
        return memberMissionRepository.existsByMissionId(missionId);
    }
    
    @Override
    public void addMissionToMember(MemberMissionDto.AddMissionToMemberRequestDTO req) {
        Mission findMission = missionRepository.findById(req.getMissionId()).orElseThrow(
                () -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND)
        );
        
        Member findMember = memberRepository.findById(req.getMemberId()).orElseThrow(
                () -> new MemberHandler(ErrorStatus.MISSION_NOT_FOUND)
        );
        MemberMission newMemberMission = MemberMissionConverter.toMemberMission(findMember,findMission);
        
        memberMissionRepository.save(newMemberMission);
    }
    
    @Override
    public Page<MemberMission> findMissionsByMember(Long memberId, String status, Integer page) {
        Member member = memberRepository.findById(memberId).get();
        MissionStatus missionStatus = MissionStatus.valueOf(status);
        
        return memberMissionRepository.findAllByMemberAndStatus(
                member,
                missionStatus,
                PageRequest.of(page, 10)
        );
    }
}