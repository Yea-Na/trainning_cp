package com.training_delivery.demo.domain.store.service;

import com.training_delivery.demo.domain.store.dto.request.StoreRegisterRequestDto;
import com.training_delivery.demo.domain.store.dto.request.StoreUpdateRequestDto;

import java.util.UUID;

public interface StoreService {
    void registerStore(StoreRegisterRequestDto requestDto, String userId);

    void deleteStroe(UUID id, String userId);


    void updateStore(StoreUpdateRequestDto requestDto, String userId, UUID id);
}
