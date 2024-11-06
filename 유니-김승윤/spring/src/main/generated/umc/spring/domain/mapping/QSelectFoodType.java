package umc.spring.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSelectFoodType is a Querydsl query type for SelectFoodType
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSelectFoodType extends EntityPathBase<SelectFoodType> {

    private static final long serialVersionUID = -882315616L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSelectFoodType selectFoodType = new QSelectFoodType("selectFoodType");

    public final umc.spring.domain.base.QBaseEntity _super = new umc.spring.domain.base.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final umc.spring.domain.QFoodType foodType;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final umc.spring.domain.QUser user;

    public QSelectFoodType(String variable) {
        this(SelectFoodType.class, forVariable(variable), INITS);
    }

    public QSelectFoodType(Path<? extends SelectFoodType> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSelectFoodType(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSelectFoodType(PathMetadata metadata, PathInits inits) {
        this(SelectFoodType.class, metadata, inits);
    }

    public QSelectFoodType(Class<? extends SelectFoodType> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.foodType = inits.isInitialized("foodType") ? new umc.spring.domain.QFoodType(forProperty("foodType")) : null;
        this.user = inits.isInitialized("user") ? new umc.spring.domain.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

