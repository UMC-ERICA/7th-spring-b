package com.umc.spring.service.MyMissionService;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.Tuple;
import com.umc.spring.domain.mapping.MyMission;
import com.umc.spring.repository.MyMissionRepository.MyMissionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MyMissionQueryServiceImpl implements MyMissionQueryService {

	private final MyMissionRepository myMissionRepository;

	@Override
	public Optional<MyMission> findMyMission(Long id) {
		return myMissionRepository.findById(id);
	}

	//1번
	@Override
	public List<Tuple> findMissionsByMemberIdAndType(Long memberId, int page) {
		List<Tuple> MyMission = myMissionRepository.dynamicQueryWithBooleanBuilder(memberId, page);

		MyMission.forEach(mission -> System.out.println("MyMission: " + mission));

		return MyMission;
	}

	//3번
	@Override
	public List<Tuple> findHomeMissionsByMemberIdAnd(Long memberId, int page) {
		List<Tuple> BeforeMission = myMissionRepository.homeDynamicQueryWithBooleanBuilder(memberId, page);

		BeforeMission.forEach(mission -> System.out.println("Before Mission: " + mission));

		return BeforeMission;
	}
}
