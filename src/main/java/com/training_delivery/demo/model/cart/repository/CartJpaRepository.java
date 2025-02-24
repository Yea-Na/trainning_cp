package com.training_delivery.demo.model.cart.repository;

import com.training_delivery.demo.model.cart.entity.Cart;
import com.training_delivery.demo.model.menu.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CartJpaRepository extends JpaRepository<Cart, UUID> {


}
