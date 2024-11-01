package com.umc.spring.domain;

import com.umc.spring.domain.common.BaseEntity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class NewEvent extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 50)
	private String title;

	@Column(length = 255)
	private String body;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "push_id")
	private PushNotification pushNotification;
}
