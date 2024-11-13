package com.umc.spring.service.MemberSerive;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.umc.spring.domain.Member;
import com.umc.spring.repository.MemberRepository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService {

	private final MemberRepository memberRepository;

	@Override
	public Optional<Member> findMember(Long id) {
		return memberRepository.findById(id);
	}


	@Override
	public List<Member> findMemberById(Long id) {
		List<Member> memberById = memberRepository.dynamicQueryWithBooleanBuilder(id);

		memberById.forEach(member -> System.out.println("Member: " + member));

		return memberById;
	}
}

