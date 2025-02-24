package com.training_delivery.demo.model.store.repository;

import com.training_delivery.demo.model.store.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreJpaRepository extends JpaRepository<Store, Long> {
}
