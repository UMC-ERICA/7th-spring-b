package com.umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QNewEvent is a Querydsl query type for NewEvent
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QNewEvent extends EntityPathBase<NewEvent> {

    private static final long serialVersionUID = 1421396499L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QNewEvent newEvent = new QNewEvent("newEvent");

    public final com.umc.spring.domain.common.QBaseEntity _super = new com.umc.spring.domain.common.QBaseEntity(this);

    public final StringPath body = createString("body");

    //inherited
    public final DatePath<java.time.LocalDate> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QPushNotification pushNotification;

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QNewEvent(String variable) {
        this(NewEvent.class, forVariable(variable), INITS);
    }

    public QNewEvent(Path<? extends NewEvent> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QNewEvent(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QNewEvent(PathMetadata metadata, PathInits inits) {
        this(NewEvent.class, metadata, inits);
    }

    public QNewEvent(Class<? extends NewEvent> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.pushNotification = inits.isInitialized("pushNotification") ? new QPushNotification(forProperty("pushNotification"), inits.get("pushNotification")) : null;
    }

}

