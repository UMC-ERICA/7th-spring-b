package umc.spring.domain.images;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QInquiryImageSave is a Querydsl query type for InquiryImageSave
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QInquiryImageSave extends EntityPathBase<InquiryImageSave> {

    private static final long serialVersionUID = 2038278715L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QInquiryImageSave inquiryImageSave = new QInquiryImageSave("inquiryImageSave");

    public final umc.spring.domain.base.QBaseEntity _super = new umc.spring.domain.base.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath fileName = createString("fileName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final umc.spring.domain.QInquiry inquiry;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final StringPath url = createString("url");

    public QInquiryImageSave(String variable) {
        this(InquiryImageSave.class, forVariable(variable), INITS);
    }

    public QInquiryImageSave(Path<? extends InquiryImageSave> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QInquiryImageSave(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QInquiryImageSave(PathMetadata metadata, PathInits inits) {
        this(InquiryImageSave.class, metadata, inits);
    }

    public QInquiryImageSave(Class<? extends InquiryImageSave> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.inquiry = inits.isInitialized("inquiry") ? new umc.spring.domain.QInquiry(forProperty("inquiry"), inits.get("inquiry")) : null;
    }

}

