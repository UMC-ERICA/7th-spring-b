package umc.spring.repository.MemberRepository;

import umc.spring.web.dto.MemberDTO;

public interface MemberRepositoryCustom {
    
    MemberDTO.MemberProfileDTO findMemberInfo(Long memberId);
}
