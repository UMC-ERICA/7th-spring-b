package com.umc.spring.repository.MemberRepository;

import java.util.List;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.umc.spring.domain.Member;
import com.umc.spring.domain.QMember;

public class MemberRepositoryImpl implements MemberRepositoryCustom {
	private final JPAQueryFactory jpaQueryFactory;
	private final QMember member = QMember.member;

	public MemberRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
		this.jpaQueryFactory = jpaQueryFactory;
	}

	@Override
	//public List<Member> dynamicQueryWithBooleanBuilder(long id, String nickname, String email , String address)
	public List<Member> dynamicQueryWithBooleanBuilder(long id){
		BooleanBuilder predicate = new BooleanBuilder();

		predicate.and(member.id.eq(id));

		return jpaQueryFactory
			.selectFrom(member)
			.where(predicate)
			.fetch();

	}
}
