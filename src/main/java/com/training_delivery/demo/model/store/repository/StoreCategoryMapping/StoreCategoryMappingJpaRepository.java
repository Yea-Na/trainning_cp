package com.training_delivery.demo.model.store.repository.StoreCategoryMapping;

import com.training_delivery.demo.model.store.entity.StoreCategory;
import com.training_delivery.demo.model.store.entity.StoreCategoryMapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreCategoryMappingJpaRepository extends JpaRepository<StoreCategoryMapping, Long> {
}
