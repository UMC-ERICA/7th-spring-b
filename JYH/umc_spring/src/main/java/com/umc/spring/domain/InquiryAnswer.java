package com.umc.spring.domain;

import com.umc.spring.domain.common.BaseEntity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class InquiryAnswer extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 50)
	private String title;

	@Column(nullable = false, columnDefinition = "text")
	private String body;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "inquiry_id")
	private Inquiry inquiry;
}
