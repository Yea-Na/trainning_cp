package com.training_delivery.demo.model.order.repository;

import com.training_delivery.demo.model.order.entity.Order;
import com.training_delivery.demo.model.owner.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderJpaRepository extends JpaRepository<Order, UUID> {


}
