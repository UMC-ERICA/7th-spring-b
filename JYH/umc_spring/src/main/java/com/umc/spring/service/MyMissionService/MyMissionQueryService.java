package com.umc.spring.service.MyMissionService;

import java.util.List;
import java.util.Optional;

import com.querydsl.core.Tuple;
import com.umc.spring.domain.mapping.MyMission;

public interface MyMissionQueryService {

	Optional<MyMission> findMyMission(Long id);

	List<Tuple> findMissionsByMemberIdAndType(Long memberId, int page);

	List<Tuple> findHomeMissionsByMemberIdAnd(Long memberId, int page);
}
