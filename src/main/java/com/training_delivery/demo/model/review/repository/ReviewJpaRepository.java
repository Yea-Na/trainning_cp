package com.training_delivery.demo.model.review.repository;

import com.training_delivery.demo.model.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewJpaRepository extends JpaRepository<Review, Long> {
}
