package umc.spring.repository.MemberRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.QMember;
import umc.spring.web.dto.MemberDTO;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {
    
    private final JPAQueryFactory jpaQueryFactory;
    private final QMember member = QMember.member;
    
    
    public MemberDTO.MemberProfileDTO findMemberInfo(Long memberId) {
        return jpaQueryFactory
                .select(Projections.fields(MemberDTO.MemberProfileDTO.class,
                        member.nickname,
                        member.email,
                        member.point
                ))
                .from(member)
                .where(member.id.eq(memberId))
                .fetchOne();
    }
}
