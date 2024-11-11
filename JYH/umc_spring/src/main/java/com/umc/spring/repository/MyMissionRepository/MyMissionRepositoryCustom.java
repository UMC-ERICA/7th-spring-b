package com.umc.spring.repository.MyMissionRepository;

import java.util.List;

import com.querydsl.core.Tuple;

public interface MyMissionRepositoryCustom {
	List<Tuple> dynamicQueryWithBooleanBuilder(Long memberId, int page);

	List<Tuple> homeDynamicQueryWithBooleanBuilder(Long memberId, int page);
}
