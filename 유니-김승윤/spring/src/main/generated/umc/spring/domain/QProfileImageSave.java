package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProfileImageSave is a Querydsl query type for ProfileImageSave
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProfileImageSave extends EntityPathBase<ProfileImageSave> {

    private static final long serialVersionUID = 701105787L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProfileImageSave profileImageSave = new QProfileImageSave("profileImageSave");

    public final umc.spring.domain.base.QBaseEntity _super = new umc.spring.domain.base.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath fileName = createString("fileName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final StringPath url = createString("url");

    public final QUser user;

    public QProfileImageSave(String variable) {
        this(ProfileImageSave.class, forVariable(variable), INITS);
    }

    public QProfileImageSave(Path<? extends ProfileImageSave> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProfileImageSave(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProfileImageSave(PathMetadata metadata, PathInits inits) {
        this(ProfileImageSave.class, metadata, inits);
    }

    public QProfileImageSave(Class<? extends ProfileImageSave> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

