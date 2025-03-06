package com.training_delivery.demo.model.store.repository.storeCategory;

import com.training_delivery.demo.model.store.entity.StoreCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreCategoryJpaRepository extends JpaRepository<StoreCategory, Long> {
}
