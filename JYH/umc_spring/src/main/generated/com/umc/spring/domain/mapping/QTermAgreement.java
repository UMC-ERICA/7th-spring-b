package com.umc.spring.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTermAgreement is a Querydsl query type for TermAgreement
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTermAgreement extends EntityPathBase<TermAgreement> {

    private static final long serialVersionUID = 341061957L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTermAgreement termAgreement = new QTermAgreement("termAgreement");

    public final com.umc.spring.domain.common.QBaseEntity _super = new com.umc.spring.domain.common.QBaseEntity(this);

    //inherited
    public final DatePath<java.time.LocalDate> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.umc.spring.domain.QMember member;

    public final com.umc.spring.domain.QTerms terms;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QTermAgreement(String variable) {
        this(TermAgreement.class, forVariable(variable), INITS);
    }

    public QTermAgreement(Path<? extends TermAgreement> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTermAgreement(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTermAgreement(PathMetadata metadata, PathInits inits) {
        this(TermAgreement.class, metadata, inits);
    }

    public QTermAgreement(Class<? extends TermAgreement> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new com.umc.spring.domain.QMember(forProperty("member")) : null;
        this.terms = inits.isInitialized("terms") ? new com.umc.spring.domain.QTerms(forProperty("terms")) : null;
    }

}

