package com.training_delivery.demo.model.payment.repository;

import com.training_delivery.demo.model.payment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentJpaRepository extends JpaRepository<Payment, Long> {
}
