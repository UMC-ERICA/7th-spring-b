package umc.spring.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository.MemberMissionRepository;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.repository.MissionRepository.MissionRepository;
import umc.spring.repository.ReviewRepository;
import umc.spring.web.dto.MemberDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService {


    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public List<MemberDto> findMemberInfo(Long memberId) {
        return memberRepository.findMemberInfoByMemberId(memberId);
    }

    @Override
    public Optional<Member> findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    @Override
    public Page<Review> getReviewList(Long memberId, Integer page) {

        Member member = memberRepository.findById(memberId).get();
        Page<Review> reviewPage = reviewRepository.findAllByMember(member, PageRequest.of(page,10));

        return reviewPage;
    }

    @Override
    public Page<Mission> getChallengingMissionList(Long memberId, Integer page) {

        Member member = memberRepository.findById(memberId).get();
        List<MemberMission> challengingMission = memberMissionRepository.findAllByMemberAndMissionStatus(member, MissionStatus.CHALLENGING);
        List<Long> missionIdList = challengingMission.stream()
                .map(MemberMission::getId).collect(Collectors.toList());
        Page<Mission> missionPage = missionRepository.findByIdIn(missionIdList, PageRequest.of(page,10));

        return missionPage;
    }

}
