package umc.spring.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.web.dto.MemberDto;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService {


    private final MemberRepository memberRepository;

    @Override
    public List<MemberDto> findMemberInfo(Long memberId) {
        return memberRepository.findMemberInfoByMemberId(memberId);
    }

}
