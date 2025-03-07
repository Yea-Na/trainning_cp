package com.training_delivery.demo.model.store.repository.store;

import com.training_delivery.demo.model.store.entity.Store;

import java.util.UUID;

public interface StoreRepository {
    Store findByStoreUuid(UUID storeUuid);

    Store save(Store store);

    void delete(Store store);
}
