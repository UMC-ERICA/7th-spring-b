package com.umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReviewAnswer is a Querydsl query type for ReviewAnswer
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReviewAnswer extends EntityPathBase<ReviewAnswer> {

    private static final long serialVersionUID = -507516433L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReviewAnswer reviewAnswer = new QReviewAnswer("reviewAnswer");

    public final com.umc.spring.domain.common.QBaseEntity _super = new com.umc.spring.domain.common.QBaseEntity(this);

    public final StringPath body = createString("body");

    //inherited
    public final DatePath<java.time.LocalDate> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QPushNotification pushNotification;

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QReviewAnswer(String variable) {
        this(ReviewAnswer.class, forVariable(variable), INITS);
    }

    public QReviewAnswer(Path<? extends ReviewAnswer> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReviewAnswer(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReviewAnswer(PathMetadata metadata, PathInits inits) {
        this(ReviewAnswer.class, metadata, inits);
    }

    public QReviewAnswer(Class<? extends ReviewAnswer> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.pushNotification = inits.isInitialized("pushNotification") ? new QPushNotification(forProperty("pushNotification"), inits.get("pushNotification")) : null;
    }

}

