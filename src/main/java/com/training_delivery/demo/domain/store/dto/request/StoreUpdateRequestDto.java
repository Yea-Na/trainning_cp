package com.training_delivery.demo.domain.store.dto.request;

import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class StoreUpdateRequestDto {
    private String storeName;
    private List<Integer> storeCategoryId;
    private String phoneNumber;
    private String storeDescription;
}
