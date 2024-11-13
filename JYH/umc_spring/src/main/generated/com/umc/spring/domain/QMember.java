package com.umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -693341677L;

    public static final QMember member = new QMember("member1");

    public final com.umc.spring.domain.common.QBaseEntity _super = new com.umc.spring.domain.common.QBaseEntity(this);

    public final StringPath address = createString("address");

    public final DatePath<java.time.LocalDate> birthday = createDate("birthday", java.time.LocalDate.class);

    //inherited
    public final DatePath<java.time.LocalDate> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final EnumPath<com.umc.spring.domain.enums.Gender> gender = createEnum("gender", com.umc.spring.domain.enums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DatePath<java.time.LocalDate> inactiveDate = createDate("inactiveDate", java.time.LocalDate.class);

    public final ListPath<Inquiry, QInquiry> inquiryList = this.<Inquiry, QInquiry>createList("inquiryList", Inquiry.class, QInquiry.class, PathInits.DIRECT2);

    public final EnumPath<com.umc.spring.domain.enums.MemberStatus> memberStatus = createEnum("memberStatus", com.umc.spring.domain.enums.MemberStatus.class);

    public final ListPath<com.umc.spring.domain.mapping.MyMission, com.umc.spring.domain.mapping.QMyMission> myMissionList = this.<com.umc.spring.domain.mapping.MyMission, com.umc.spring.domain.mapping.QMyMission>createList("myMissionList", com.umc.spring.domain.mapping.MyMission.class, com.umc.spring.domain.mapping.QMyMission.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final StringPath nickname = createString("nickname");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final ListPath<PushNotification, QPushNotification> pushNotificationList = this.<PushNotification, QPushNotification>createList("pushNotificationList", PushNotification.class, QPushNotification.class, PathInits.DIRECT2);

    public final ListPath<com.umc.spring.domain.mapping.ReviewComment, com.umc.spring.domain.mapping.QReviewComment> reviewCommentList = this.<com.umc.spring.domain.mapping.ReviewComment, com.umc.spring.domain.mapping.QReviewComment>createList("reviewCommentList", com.umc.spring.domain.mapping.ReviewComment.class, com.umc.spring.domain.mapping.QReviewComment.class, PathInits.DIRECT2);

    public final ListPath<com.umc.spring.domain.mapping.Review, com.umc.spring.domain.mapping.QReview> reviewList = this.<com.umc.spring.domain.mapping.Review, com.umc.spring.domain.mapping.QReview>createList("reviewList", com.umc.spring.domain.mapping.Review.class, com.umc.spring.domain.mapping.QReview.class, PathInits.DIRECT2);

    public final ListPath<com.umc.spring.domain.mapping.Tag, com.umc.spring.domain.mapping.QTag> tagList = this.<com.umc.spring.domain.mapping.Tag, com.umc.spring.domain.mapping.QTag>createList("tagList", com.umc.spring.domain.mapping.Tag.class, com.umc.spring.domain.mapping.QTag.class, PathInits.DIRECT2);

    public final ListPath<com.umc.spring.domain.mapping.TermAgreement, com.umc.spring.domain.mapping.QTermAgreement> termAgreementList = this.<com.umc.spring.domain.mapping.TermAgreement, com.umc.spring.domain.mapping.QTermAgreement>createList("termAgreementList", com.umc.spring.domain.mapping.TermAgreement.class, com.umc.spring.domain.mapping.QTermAgreement.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

