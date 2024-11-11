/*package com.umc.spring.repository.Review;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.umc.spring.domain.mapping.Review;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {

	private EntityManager entityManager;

	@Override
	public void insertReview(int score, String contents, String imageUrl) {
		Review review = new Review();
		review.getScore(score);
		review.getContents(contents);
		review.setImages(imageUrl);

		entityManager.persist(review);
	}
}
*/