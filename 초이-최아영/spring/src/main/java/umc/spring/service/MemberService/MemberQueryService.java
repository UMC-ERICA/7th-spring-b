package umc.spring.service.MemberService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.web.dto.MemberDto;

import java.util.List;
import java.util.Optional;

public interface MemberQueryService {

    List<MemberDto> findMemberInfo(Long memberId);
    Optional<Member> findMember(Long memberId);

    Page<Review> getReviewList(Long memberId, Integer page);
    Page<Mission> getChallengingMissionList(Long memberId, Integer page);
}
