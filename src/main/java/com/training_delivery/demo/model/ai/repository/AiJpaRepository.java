package com.training_delivery.demo.model.ai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AiJpaRepository extends JpaRepository<Ai, Long> {
}
