package com.training_delivery.demo.model.store.repository.storeCategory;

import com.training_delivery.demo.model.store.entity.StoreCategory;
import com.training_delivery.demo.model.store.repository.store.StoreJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class StoreCategoryRepositoryImpl implements StoreCategoryRepository {
    private final StoreCategoryJpaRepository storeCategoryJpaRepository;


    @Override
    public List<StoreCategory> saveAll(List<StoreCategory> storeCategoryList) {
        return storeCategoryJpaRepository.saveAll(storeCategoryList);
    }
}



