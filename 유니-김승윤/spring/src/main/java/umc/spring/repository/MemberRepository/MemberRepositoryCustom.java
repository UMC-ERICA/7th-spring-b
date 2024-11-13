package umc.spring.repository.MemberRepository;

import umc.spring.web.dto.MemberDto;

public interface MemberRepositoryCustom {
    
    MemberDto.MemberProfileDto findMemberInfo(Long memberId);
}
