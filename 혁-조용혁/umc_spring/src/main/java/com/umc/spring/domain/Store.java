package com.umc.spring.domain;

import java.util.ArrayList;
import java.util.List;

import com.umc.spring.domain.common.BaseEntity;
import com.umc.spring.domain.mapping.Review;
import com.umc.spring.domain.mapping.Tag;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String address;

	@OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
	private List<Review> reviewList = new ArrayList<>();

	@OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
	private List<Tag> tagList = new ArrayList<>();

	@OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
	private List<Mission> missionList = new ArrayList<>();
}
