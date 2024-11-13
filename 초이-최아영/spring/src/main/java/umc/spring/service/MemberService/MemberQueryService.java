package umc.spring.service.MemberService;

import umc.spring.web.dto.MemberDto;

import java.util.List;

public interface MemberQueryService {

    List<MemberDto> findMemberInfo(Long memberId);

}
