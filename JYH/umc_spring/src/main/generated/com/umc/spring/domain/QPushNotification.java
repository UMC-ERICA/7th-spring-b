package com.umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPushNotification is a Querydsl query type for PushNotification
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPushNotification extends EntityPathBase<PushNotification> {

    private static final long serialVersionUID = 1330141534L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPushNotification pushNotification = new QPushNotification("pushNotification");

    public final com.umc.spring.domain.common.QBaseEntity _super = new com.umc.spring.domain.common.QBaseEntity(this);

    //inherited
    public final DatePath<java.time.LocalDate> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isConfirmed = createBoolean("isConfirmed");

    public final QMember member;

    public final ListPath<NewEvent, QNewEvent> newEventList = this.<NewEvent, QNewEvent>createList("newEventList", NewEvent.class, QNewEvent.class, PathInits.DIRECT2);

    public final ListPath<ReviewAnswer, QReviewAnswer> reviewAnswerList = this.<ReviewAnswer, QReviewAnswer>createList("reviewAnswerList", ReviewAnswer.class, QReviewAnswer.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QPushNotification(String variable) {
        this(PushNotification.class, forVariable(variable), INITS);
    }

    public QPushNotification(Path<? extends PushNotification> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPushNotification(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPushNotification(PathMetadata metadata, PathInits inits) {
        this(PushNotification.class, metadata, inits);
    }

    public QPushNotification(Class<? extends PushNotification> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
    }

}

