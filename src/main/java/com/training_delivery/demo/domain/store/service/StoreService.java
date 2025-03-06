package com.training_delivery.demo.domain.store.service;

import com.training_delivery.demo.domain.store.dto.request.StoreRegisterRequestDto;

public interface StoreService {
    void registerStore(StoreRegisterRequestDto requestDto, String userId);
}
