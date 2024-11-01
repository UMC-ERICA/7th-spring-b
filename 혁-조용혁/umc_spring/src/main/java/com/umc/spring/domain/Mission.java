package com.umc.spring.domain;

import java.time.LocalDate;

import com.umc.spring.domain.common.BaseEntity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 50)
	private String title;

	@Column(nullable = false, length = 255)
	private String body;

	@Column(nullable = false)
	private LocalDate deadline;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "store_id")
	private Store store;
}
