package com.umc.spring.service.MemberSerive;

import java.util.List;
import java.util.Optional;

import com.umc.spring.domain.Member;
import com.umc.spring.domain.Store;

public interface MemberQueryService {

	Optional<Member> findMember(Long id);
	List<Member> findMemberById(Long id);
}