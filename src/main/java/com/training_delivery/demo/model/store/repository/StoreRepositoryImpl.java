package com.training_delivery.demo.model.store.repository;

import com.training_delivery.demo.model.store.entity.Store;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class StoreRepositoryImpl implements StoreRepository {
    private final StoreJpaRepository storeJpaRepository;

    @Override
    public Store findByUuid(UUID storeUuid) {
        return storeJpaRepository.findByUuid(storeUuid);
    }
}
