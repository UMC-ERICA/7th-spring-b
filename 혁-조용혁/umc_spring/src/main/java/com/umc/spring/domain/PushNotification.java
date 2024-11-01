package com.umc.spring.domain;

import java.util.ArrayList;
import java.util.List;

import com.umc.spring.domain.common.BaseEntity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class PushNotification extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, columnDefinition = "DEFAULT 0")
	private boolean isConfirmed;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member member;

	@OneToMany(mappedBy = "pushNotification", cascade = CascadeType.ALL)
	private List<ReviewAnswer> reviewAnswerList = new ArrayList<>();

	@OneToMany(mappedBy = "pushNotification", cascade = CascadeType.ALL)
	private List<NewEvent> newEventList = new ArrayList<>();
}
