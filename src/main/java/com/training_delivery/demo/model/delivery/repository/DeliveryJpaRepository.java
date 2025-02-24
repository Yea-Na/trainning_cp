package com.training_delivery.demo.model.delivery.repository;

import com.training_delivery.demo.model.delivery.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryJpaRepository extends JpaRepository<Delivery, Long> {
}
