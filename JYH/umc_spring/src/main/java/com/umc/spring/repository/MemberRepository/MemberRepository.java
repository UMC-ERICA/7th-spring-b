package com.umc.spring.repository.MemberRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.umc.spring.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {

}
