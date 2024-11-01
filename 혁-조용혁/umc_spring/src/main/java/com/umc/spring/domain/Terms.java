package com.umc.spring.domain;

import java.util.ArrayList;
import java.util.List;

import com.umc.spring.domain.common.BaseEntity;
import com.umc.spring.domain.enums.TermEssential;
import com.umc.spring.domain.mapping.TermAgreement;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Terms extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 50)
	private String title;

	@Column(nullable = false, length = 255)
	private String body;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, columnDefinition = "VARCHAR(13) DEFAULT 'NOT_ESSENTIAL'")
	private TermEssential termEssential;

	@OneToMany(mappedBy = "terms", cascade = CascadeType.ALL)
	private List<TermAgreement> termAgreementList = new ArrayList<>();
}
