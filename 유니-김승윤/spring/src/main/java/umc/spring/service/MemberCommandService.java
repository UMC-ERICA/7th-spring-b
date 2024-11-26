package umc.spring.service;

import umc.spring.domain.Member;
import umc.spring.web.dto.MemberDTO;

public interface MemberCommandService {
    
    Member joinMember(MemberDTO.memberJoinDTO request);
}
