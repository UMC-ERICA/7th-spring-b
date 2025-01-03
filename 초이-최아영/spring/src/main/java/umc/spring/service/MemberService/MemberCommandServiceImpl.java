package umc.spring.service.MemberService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.CategoryHandler;
import umc.spring.apiPayload.exception.handler.MemberHandler;
import umc.spring.apiPayload.exception.handler.MissionHandler;
import umc.spring.converter.FavCategoryConverter;
import umc.spring.converter.MemberConverter;
import umc.spring.domain.Category;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.FavCategory;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.CategoryRepository.CategoryRepository;
import umc.spring.repository.MemberMissionRepository.MemberMissionRepository;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.repository.MissionRepository.MissionRepository;
import umc.spring.web.dto.MemberRequestDTO;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;
    private final CategoryRepository categoryRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        List<Category> categoryList = request.getFavCategory().stream()
                .map(category -> {
                    return categoryRepository.findById(category).orElseThrow(() -> new CategoryHandler(ErrorStatus.CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<FavCategory> favCategoryList = FavCategoryConverter.toFavCategoryList(categoryList);

        favCategoryList.forEach(favCategory -> {favCategory.setMember(newMember);});

        return memberRepository.save(newMember);
    }

    @Override
    @Transactional
    public MemberMission challengeMission(MemberRequestDTO.ChallengeMissionDTO request) {

        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        MemberMission newMemberMission = MemberConverter.toMemberMission(member, mission);

        return memberMissionRepository.save(newMemberMission);
    }

}
