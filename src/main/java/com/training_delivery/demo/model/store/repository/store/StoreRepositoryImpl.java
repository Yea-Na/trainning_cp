package com.training_delivery.demo.model.store.repository.store;

import com.training_delivery.demo.model.store.entity.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class StoreRepositoryImpl implements StoreRepository {
    private final StoreJpaRepository storeJpaRepository;

    @Override
    public Store findByStoreUuid(UUID storeUuid) {
        return storeJpaRepository.findByStoreUuid(storeUuid);
    }

    @Override
    public Store save(Store store) {
        return storeJpaRepository.save(store);
    }

    @Override
    public void delete(Store store) {
         storeJpaRepository.delete(store);
    }
}
