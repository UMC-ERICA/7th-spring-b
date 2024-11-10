package umc.spring.repository.MemberRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import umc.spring.domain.QMember;
import umc.spring.web.dto.MemberDto;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QMember member = QMember.member;

    @Override
    public List<MemberDto> findMemberInfoByMemberId(Long memberId) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (memberId != null) {
            predicate.and(member.id.eq(memberId));
        }

        return jpaQueryFactory
                .select(Projections.constructor(MemberDto.class,
                        member.name,
                        member.email,
                        member.phoneNum,
                        member.point
                ))
                .from(member)
                .where(predicate)
                .fetch();
    }

}
