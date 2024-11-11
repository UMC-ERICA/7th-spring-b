package com.umc.spring.service.ReveiwService;

import org.springframework.stereotype.Service;

import com.umc.spring.domain.mapping.Review;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewQueryService {
	private final EntityManager entityManager;

	@Transactional
	public void insertReview(int score, String contents, String images) {
		Review review = Review.builder()
			.score(score)
			.contents(contents)
			.imageUrl(images)
			.build();
		entityManager.persist(review); // 데이터베이스에 삽입
	}
}