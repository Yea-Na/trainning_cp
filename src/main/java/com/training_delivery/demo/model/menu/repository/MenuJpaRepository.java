package com.training_delivery.demo.model.menu.repository;

import com.training_delivery.demo.model.menu.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuJpaRepository extends JpaRepository<Menu, Long> {
}
