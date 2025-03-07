package com.training_delivery.demo.model.store.repository.StoreCategoryMapping;

import com.training_delivery.demo.model.store.entity.StoreCategoryMapping;
import com.training_delivery.demo.model.store.repository.storeCategory.StoreCategoryJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StoreCatrgoryMappingRepositoryImpl implements StoreCategoryMappingRepository {
    private final StoreCategoryMappingJpaRepository storeCategoryMappingJpaRepository;
    @Override
    public List<StoreCategoryMapping> saveAll(List<StoreCategoryMapping> categoryMappings) {
        return storeCategoryMappingJpaRepository.saveAll(categoryMappings);
    }
}
