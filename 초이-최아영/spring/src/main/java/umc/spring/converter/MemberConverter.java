package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.Gender;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.MemberResponseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {

    public static Member toMember(MemberRequestDTO.JoinDto request) {

        Gender gender = null;
        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        LocalDate birth = LocalDate.of(
                request.getBirthYear(),
                request.getBirthMonth(),
                request.getBirthDay());

        return Member.builder()
                .name(request.getName())
                .gender(gender)
                .birth(birth)
                .address(request.getAddress())
                .favCategoryList(new ArrayList<>())
                .build();
    }

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member) {
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static MemberMission toMemberMission(Member member, Mission mission) {

        MissionStatus missionStatus = MissionStatus.CHALLENGING;

        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .missionStatus(missionStatus)
                .build();
    }

    public static MemberResponseDTO.ChallengeMissionResultDTO toChallengeMissionResultDTO(MemberMission memberMission) {
        return MemberResponseDTO.ChallengeMissionResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

}
