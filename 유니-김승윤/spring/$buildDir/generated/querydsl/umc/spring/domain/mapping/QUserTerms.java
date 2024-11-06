package umc.spring.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserTerms is a Querydsl query type for UserTerms
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserTerms extends EntityPathBase<UserTerms> {

    private static final long serialVersionUID = -304782288L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserTerms userTerms = new QUserTerms("userTerms");

    public final BooleanPath agreed = createBoolean("agreed");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final umc.spring.domain.QTerms terms;

    public final umc.spring.domain.QUser user;

    public QUserTerms(String variable) {
        this(UserTerms.class, forVariable(variable), INITS);
    }

    public QUserTerms(Path<? extends UserTerms> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserTerms(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserTerms(PathMetadata metadata, PathInits inits) {
        this(UserTerms.class, metadata, inits);
    }

    public QUserTerms(Class<? extends UserTerms> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.terms = inits.isInitialized("terms") ? new umc.spring.domain.QTerms(forProperty("terms")) : null;
        this.user = inits.isInitialized("user") ? new umc.spring.domain.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

