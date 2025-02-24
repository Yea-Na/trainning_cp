package com.training_delivery.demo.domain.store.dto.request;

import lombok.Getter;

import java.util.List;

@Getter
public class StoreUpdateRequestDto {
    private String storeName;
    private List<Integer> storeCategoryId;
    private String phoneNumeber;
    private String storeDescription;
}
