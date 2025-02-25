package com.training_delivery.demo.model.store.repository;

import com.training_delivery.demo.model.store.entity.Store;

import java.util.UUID;

public interface StoreRepository {
    Store findByUuid(UUID storeUuid);
}
