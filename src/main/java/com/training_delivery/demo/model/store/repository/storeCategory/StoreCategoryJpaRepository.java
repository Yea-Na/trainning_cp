package com.training_delivery.demo.model.store.repository.storeCategory;

import com.training_delivery.demo.model.store.entity.StoreCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface StoreCategoryJpaRepository extends JpaRepository<StoreCategory, UUID> {
}
