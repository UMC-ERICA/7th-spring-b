package umc.spring.domain.images;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStoreImageSave is a Querydsl query type for StoreImageSave
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStoreImageSave extends EntityPathBase<StoreImageSave> {

    private static final long serialVersionUID = 932168417L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStoreImageSave storeImageSave = new QStoreImageSave("storeImageSave");

    public final umc.spring.domain.base.QBaseEntity _super = new umc.spring.domain.base.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath fileName = createString("fileName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final umc.spring.domain.QStore store;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final StringPath url = createString("url");

    public QStoreImageSave(String variable) {
        this(StoreImageSave.class, forVariable(variable), INITS);
    }

    public QStoreImageSave(Path<? extends StoreImageSave> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStoreImageSave(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStoreImageSave(PathMetadata metadata, PathInits inits) {
        this(StoreImageSave.class, metadata, inits);
    }

    public QStoreImageSave(Class<? extends StoreImageSave> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.store = inits.isInitialized("store") ? new umc.spring.domain.QStore(forProperty("store"), inits.get("store")) : null;
    }

}

