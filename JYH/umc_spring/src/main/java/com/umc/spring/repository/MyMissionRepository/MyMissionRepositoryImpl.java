package com.umc.spring.repository.MyMissionRepository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.umc.spring.domain.QMember;
import com.umc.spring.domain.QMission;
import com.umc.spring.domain.QStore;
import com.umc.spring.domain.enums.MissionType;
import com.umc.spring.domain.mapping.QMyMission;
import com.umc.spring.domain.mapping.QTag;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MyMissionRepositoryImpl implements MyMissionRepositoryCustom {
	private final JPAQueryFactory jpaqueryFactory;
	private final QMyMission myMission = QMyMission.myMission;
	private final QMission mission = QMission.mission;
	private final QStore store = QStore.store;
	private final QTag tag = QTag.tag;
	private final QMember member = QMember.member;

	//1번 문제 미션목록
	@Override
	public List<Tuple> dynamicQueryWithBooleanBuilder(Long memberId, int page) {

		BooleanBuilder predicate = new BooleanBuilder();
		predicate.and(myMission.member.id.eq(memberId));
		predicate.and(myMission.missionType.in(MissionType.PROGRESS, MissionType.COMPLETE));

		return jpaqueryFactory
			.select(mission.title, mission.body, store.name)
			.from(myMission)
			.join(myMission.mission, mission)
			.join(mission.store, store)
			.where(predicate)
			.orderBy(mission.createdAt.desc())
			.limit(100)
			.offset((page - 1) * 100L)
			.fetch();
	}

	//3번 문제 홈화면
	@Override
	public List<Tuple> homeDynamicQueryWithBooleanBuilder(Long memberId, int page) {

		BooleanBuilder predicate = new BooleanBuilder();
		predicate.and(myMission.member.id.eq(memberId));
		predicate.and(myMission.missionType.in(MissionType.BEFORE));

		return jpaqueryFactory
			.select(mission.title, mission.body, store.name, tag.title, member.address)
			.from(myMission)
			.join(myMission.member, member)
			.join(myMission.mission, mission)
			.join(mission.store, store)
			.join(tag.store, store)
			.where(predicate)
			.orderBy(mission.deadline.desc())
			.limit(10)
			.offset((page - 1) * 10L)
			.fetch();
	}
}
