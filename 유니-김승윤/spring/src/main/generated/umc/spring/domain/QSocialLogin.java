package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSocialLogin is a Querydsl query type for SocialLogin
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSocialLogin extends EntityPathBase<SocialLogin> {

    private static final long serialVersionUID = -1686315056L;

    public static final QSocialLogin socialLogin = new QSocialLogin("socialLogin");

    public final umc.spring.domain.base.QBaseEntity _super = new umc.spring.domain.base.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<umc.spring.domain.enums.SocialLoginType> type = createEnum("type", umc.spring.domain.enums.SocialLoginType.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QSocialLogin(String variable) {
        super(SocialLogin.class, forVariable(variable));
    }

    public QSocialLogin(Path<? extends SocialLogin> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSocialLogin(PathMetadata metadata) {
        super(SocialLogin.class, metadata);
    }

}

