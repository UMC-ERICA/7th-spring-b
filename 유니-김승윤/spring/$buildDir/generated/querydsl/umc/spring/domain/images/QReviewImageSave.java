package umc.spring.domain.images;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReviewImageSave is a Querydsl query type for ReviewImageSave
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReviewImageSave extends EntityPathBase<ReviewImageSave> {

    private static final long serialVersionUID = 369154294L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReviewImageSave reviewImageSave = new QReviewImageSave("reviewImageSave");

    public final umc.spring.domain.base.QBaseEntity _super = new umc.spring.domain.base.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath fileName = createString("fileName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final umc.spring.domain.QReview review;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final StringPath url = createString("url");

    public QReviewImageSave(String variable) {
        this(ReviewImageSave.class, forVariable(variable), INITS);
    }

    public QReviewImageSave(Path<? extends ReviewImageSave> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReviewImageSave(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReviewImageSave(PathMetadata metadata, PathInits inits) {
        this(ReviewImageSave.class, metadata, inits);
    }

    public QReviewImageSave(Class<? extends ReviewImageSave> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.review = inits.isInitialized("review") ? new umc.spring.domain.QReview(forProperty("review"), inits.get("review")) : null;
    }

}

