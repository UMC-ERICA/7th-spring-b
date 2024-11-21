package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;

import java.time.LocalDateTime;
import java.util.UUID;

public class MemberMissionConverter {
    
    public static MemberMission toMemberMission(Member member, Mission mission) {
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .deadline(LocalDateTime.now().plusDays(7))
                .uuid(String.valueOf(UUID.randomUUID()))
                .build();
    }
    
}
