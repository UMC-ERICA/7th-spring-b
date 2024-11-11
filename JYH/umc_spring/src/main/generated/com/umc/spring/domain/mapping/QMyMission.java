package com.umc.spring.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMyMission is a Querydsl query type for MyMission
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMyMission extends EntityPathBase<MyMission> {

    private static final long serialVersionUID = -406480889L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMyMission myMission = new QMyMission("myMission");

    public final com.umc.spring.domain.common.QBaseEntity _super = new com.umc.spring.domain.common.QBaseEntity(this);

    //inherited
    public final DatePath<java.time.LocalDate> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.umc.spring.domain.QMember member;

    public final com.umc.spring.domain.QMission mission;

    public final EnumPath<com.umc.spring.domain.enums.MissionType> missionType = createEnum("missionType", com.umc.spring.domain.enums.MissionType.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMyMission(String variable) {
        this(MyMission.class, forVariable(variable), INITS);
    }

    public QMyMission(Path<? extends MyMission> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMyMission(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMyMission(PathMetadata metadata, PathInits inits) {
        this(MyMission.class, metadata, inits);
    }

    public QMyMission(Class<? extends MyMission> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new com.umc.spring.domain.QMember(forProperty("member")) : null;
        this.mission = inits.isInitialized("mission") ? new com.umc.spring.domain.QMission(forProperty("mission"), inits.get("mission")) : null;
    }

}

