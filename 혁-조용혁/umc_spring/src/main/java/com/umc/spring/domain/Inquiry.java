package com.umc.spring.domain;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

import com.umc.spring.domain.common.BaseEntity;
import com.umc.spring.domain.enums.InquiryType;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Inquiry extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 50)
	private String title;

	@Column(length = 500)
	private String body;

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "varchar(6)")
	private InquiryType inquiryType;

	@Column(nullable = false, columnDefinition = "text")
	private String imageUrl;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member member;

	@OneToMany(mappedBy = "inquiry", cascade = CascadeType.ALL)
	private List<InquiryAnswer> inquiryAnswerList = new ArrayList<>();
}
