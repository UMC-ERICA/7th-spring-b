package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QFoodType is a Querydsl query type for FoodType
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFoodType extends EntityPathBase<FoodType> {

    private static final long serialVersionUID = 414254436L;

    public static final QFoodType foodType = new QFoodType("foodType");

    public final umc.spring.domain.base.QBaseEntity _super = new umc.spring.domain.base.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QFoodType(String variable) {
        super(FoodType.class, forVariable(variable));
    }

    public QFoodType(Path<? extends FoodType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFoodType(PathMetadata metadata) {
        super(FoodType.class, metadata);
    }

}

