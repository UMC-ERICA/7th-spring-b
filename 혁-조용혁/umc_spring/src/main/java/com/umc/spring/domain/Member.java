package com.umc.spring.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.umc.spring.domain.common.BaseEntity;
import com.umc.spring.domain.enums.Gender;
import com.umc.spring.domain.enums.MemberStatus;
import com.umc.spring.domain.mapping.MyMission;
import com.umc.spring.domain.mapping.Review;
import com.umc.spring.domain.mapping.ReviewComment;
import com.umc.spring.domain.mapping.Tag;
import com.umc.spring.domain.mapping.TermAgreement;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 40)
	private String name;

	@Column(nullable = false, length = 20)
	private String nickname;

	@Column(nullable = false, length = 15)
	private String phoneNumber;

	@Column(nullable = false, length = 100)
	private String address;

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "VARCHAR(10)")
	private Gender gender;

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
	private MemberStatus memberStatus;

	@Column(nullable = false)
	private LocalDate birthday;

	private LocalDate inactiveDate;

	@Column(nullable = false, length = 30)
	private String email;

	private Integer point;

	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	private List<TermAgreement> termAgreementList = new ArrayList<>();

	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	private List<Review> reviewList = new ArrayList<>();

	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	private List<ReviewComment> reviewCommentList = new ArrayList<>();

	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	private List<PushNotification> pushNotificationList = new ArrayList<>();

	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	private List<Tag> tagList = new ArrayList<>();

	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	private List<MyMission> myMissionList = new ArrayList<>();

	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	private List<Inquiry> inquiryList = new ArrayList<>();
}
