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

	private String title;

	private String body;

	@Enumerated(EnumType.STRING)
	private TermEssential termEssential;

	@OneToMany(mappedBy = "terms", cascade = CascadeType.ALL)
	private List<TermAgreement> termAgreementList = new ArrayList<>();
}
