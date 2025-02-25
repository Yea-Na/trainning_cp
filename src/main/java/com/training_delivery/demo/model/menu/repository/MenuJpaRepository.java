package com.training_delivery.demo.model.menu.repository;

import com.training_delivery.demo.model.menu.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuJpaRepository extends JpaRepository<Menu, Long> {

}
