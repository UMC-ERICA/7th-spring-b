package com.umc.spring.repository.MemberRepository;

import java.util.List;

import com.umc.spring.domain.Member;

public interface MemberRepositoryCustom {

	//List<Member> dynamicQueryWithBooleanBuilder(long id, String nickname, String email , String address);

	List<Member> dynamicQueryWithBooleanBuilder(long id);

}
