package umc.spring.repository.MissionRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import umc.spring.domain.QMember;
import umc.spring.domain.QMission;
import umc.spring.domain.mapping.QMemberMission;
import umc.spring.domain.QRestaurant;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.Mission;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryCustomImpl implements MissionRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QMember member = QMember.member;
    private final QMemberMission memberMission = QMemberMission.memberMission;
    private final QMission mission = QMission.mission;
    private final QRestaurant restaurant = QRestaurant.restaurant;


    @Override
    public List<Mission> findProgressingMissionsByMemberId(Long memberId) {

        BooleanBuilder predicate = new BooleanBuilder();

        if (memberId != null) {
            predicate.and(member.id.eq(memberId));
        }

        predicate.and(memberMission.missionStatus.eq(MissionStatus.valueOf("progressing")));

        return jpaQueryFactory
                .select(mission)
                .from(member)
                .join(memberMission).on(member.id.eq(memberMission.member.id))
                .join(mission).on(mission.id.eq(memberMission.mission.id))
                .where(predicate)
                .fetch();
    }

    @Override
    public List<Mission> findCompletedMissionsByMemberId(Long memberId) {

        BooleanBuilder predicate = new BooleanBuilder();

        if (memberId != null) {
            predicate.and(member.id.eq(memberId));
        }

        predicate.and(memberMission.missionStatus.eq(MissionStatus.valueOf("completed")));

        return jpaQueryFactory
                .select(mission)
                .from(member)
                .join(memberMission).on(member.id.eq(memberMission.member.id))
                .join(mission).on(mission.id.eq(memberMission.mission.id))
                .where(predicate)
                .fetch();
    }

    @Override
    public List<Mission> findAvailableMissionsByMemberId(Long memberId) {

        BooleanBuilder predicate = new BooleanBuilder();
        predicate.and(mission.id.notIn(
                JPAExpressions
                        .select(memberMission.mission.id)
                        .from(memberMission)
                        .where(memberMission.member.id.eq(memberId))
        ));

        return jpaQueryFactory
                .selectFrom(mission)
                .join(restaurant).on(mission.restaurant.id.eq(restaurant.id))
                .join(member).on(restaurant.region.eq(member.address))
                .where(member.id.eq(memberId)
                        .and(predicate))
                .fetch();
    }

}
