package umc.spring.repository.MemberRepository;

import umc.spring.web.dto.MemberDto;

import java.util.List;

public interface MemberRepositoryCustom {
    List<MemberDto> findMemberInfoByMemberId(Long memberId);
}
