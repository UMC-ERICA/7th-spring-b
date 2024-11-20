package umc.spring.repository.MemberMissionRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.QMission;
import umc.spring.domain.QStore;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.domain.mapping.QMemberMission;
import umc.spring.web.dto.MemberMissionDto;

import java.util.Arrays;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberMissionRepositoryImpl implements MemberMissionRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QMemberMission memberMission = QMemberMission.memberMission;
    private final QMission mission = QMission.mission;
    private final QStore store = QStore.store;
    
    @Override
    public List<MemberMission> findMemberMissions(Long memberId) {
        BooleanBuilder predicate = new BooleanBuilder();
        List<MissionStatus> statuses = Arrays.asList(MissionStatus.ACTIVE, MissionStatus.COMPLETED);
        
        // 기본 조건: memberId와 status 조건 추가
        predicate.and(memberMission.member.id.eq(memberId));
        predicate.and(memberMission.status.in(statuses));
        
        
        return jpaQueryFactory
                .select(memberMission)
                .from(memberMission)
                .join(memberMission.mission, mission)
                .join(mission.store, store)
                .where(predicate)
                .limit(10)
                .offset(0)
                .fetch();
    }
    
    @Override
    public MemberMissionDto.MissionSummary getMissionSummary(Long memberId) {
        
        return jpaQueryFactory
                .select(Projections.bean(MemberMissionDto.MissionSummary.class,
                        memberMission.id.count().as("totalMissionCount"),
                        memberMission.status
                                .eq(MissionStatus.ACTIVE)
                                .count()
                                .as("currentMissionCount")
                ))
                .from(memberMission)
                .where(memberMission.member.id.eq(memberId))
                .fetchOne();
    }
    
    @Override
    public List<MemberMissionDto.HomeMissionDto> findMissionInfo(Long memberId) {
        return jpaQueryFactory
                .select(Projections.fields(MemberMissionDto.HomeMissionDto.class,
                        store.name.as("storeName"),
                        store.category,
                        mission.missionPrice.as("missionCondition"),
                        mission.point.as("rewardPoint"),
                        memberMission.deadline.as("remainingDays"),
                        memberMission.status
                ))
                .from(memberMission)
                .join(memberMission.mission, mission)
                .join(mission.store, store)
                .where(
                        memberMission.member.id.eq(memberId),
                        memberMission.status.eq(MissionStatus.ACTIVE)
                )
                .limit(10)
                .offset(0)
                .fetch();
    }
    
}
