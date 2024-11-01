package com.umc.spring.domain;

import java.util.ArrayList;
import java.util.List;

import com.umc.spring.domain.common.BaseEntity;
import com.umc.spring.domain.mapping.TermAgreement;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Alarm extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private boolean isConfirmed;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member member;

	@OneToMany(mappedBy = "alarm", cascade = CascadeType.ALL)
	private List<InquiryAnswer> inquiryAnswerList = new ArrayList<>();

	@OneToMany(mappedBy = "alarm", cascade = CascadeType.ALL)
	private List<ReviewAnswer> reviewAnswerList = new ArrayList<>();

	@OneToMany(mappedBy = "alarm", cascade = CascadeType.ALL)
	private List<NewEvent> newEventList = new ArrayList<>();
}
