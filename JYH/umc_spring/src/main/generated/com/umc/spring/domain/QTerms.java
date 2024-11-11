package com.umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTerms is a Querydsl query type for Terms
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTerms extends EntityPathBase<Terms> {

    private static final long serialVersionUID = -847180050L;

    public static final QTerms terms = new QTerms("terms");

    public final com.umc.spring.domain.common.QBaseEntity _super = new com.umc.spring.domain.common.QBaseEntity(this);

    public final StringPath body = createString("body");

    //inherited
    public final DatePath<java.time.LocalDate> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<com.umc.spring.domain.mapping.TermAgreement, com.umc.spring.domain.mapping.QTermAgreement> termAgreementList = this.<com.umc.spring.domain.mapping.TermAgreement, com.umc.spring.domain.mapping.QTermAgreement>createList("termAgreementList", com.umc.spring.domain.mapping.TermAgreement.class, com.umc.spring.domain.mapping.QTermAgreement.class, PathInits.DIRECT2);

    public final EnumPath<com.umc.spring.domain.enums.TermEssential> termEssential = createEnum("termEssential", com.umc.spring.domain.enums.TermEssential.class);

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QTerms(String variable) {
        super(Terms.class, forVariable(variable));
    }

    public QTerms(Path<? extends Terms> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTerms(PathMetadata metadata) {
        super(Terms.class, metadata);
    }

}

