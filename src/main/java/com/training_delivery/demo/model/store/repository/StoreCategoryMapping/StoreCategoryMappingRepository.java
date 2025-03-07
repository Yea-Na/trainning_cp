package com.training_delivery.demo.model.store.repository.StoreCategoryMapping;

import com.training_delivery.demo.model.store.entity.StoreCategoryMapping;

import java.util.List;

public interface StoreCategoryMappingRepository {
    List<StoreCategoryMapping> saveAll(List<StoreCategoryMapping> categoryMappings);
}
