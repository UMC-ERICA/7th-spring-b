package com.umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStore is a Querydsl query type for Store
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStore extends EntityPathBase<Store> {

    private static final long serialVersionUID = -847659448L;

    public static final QStore store = new QStore("store");

    public final com.umc.spring.domain.common.QBaseEntity _super = new com.umc.spring.domain.common.QBaseEntity(this);

    public final StringPath address = createString("address");

    //inherited
    public final DatePath<java.time.LocalDate> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<Mission, QMission> missionList = this.<Mission, QMission>createList("missionList", Mission.class, QMission.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final ListPath<com.umc.spring.domain.mapping.Review, com.umc.spring.domain.mapping.QReview> reviewList = this.<com.umc.spring.domain.mapping.Review, com.umc.spring.domain.mapping.QReview>createList("reviewList", com.umc.spring.domain.mapping.Review.class, com.umc.spring.domain.mapping.QReview.class, PathInits.DIRECT2);

    public final ListPath<com.umc.spring.domain.mapping.Tag, com.umc.spring.domain.mapping.QTag> tagList = this.<com.umc.spring.domain.mapping.Tag, com.umc.spring.domain.mapping.QTag>createList("tagList", com.umc.spring.domain.mapping.Tag.class, com.umc.spring.domain.mapping.QTag.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QStore(String variable) {
        super(Store.class, forVariable(variable));
    }

    public QStore(Path<? extends Store> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStore(PathMetadata metadata) {
        super(Store.class, metadata);
    }

}

