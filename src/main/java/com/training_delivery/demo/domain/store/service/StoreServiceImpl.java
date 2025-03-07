package com.training_delivery.demo.domain.store.service;

import com.training_delivery.demo.domain.store.dto.request.StoreRegisterRequestDto;
import com.training_delivery.demo.domain.store.dto.request.StoreUpdateRequestDto;
import com.training_delivery.demo.model.store.constant.SeoulAreaCode;
import com.training_delivery.demo.model.store.constant.StoreType;
import com.training_delivery.demo.model.store.entity.Location;
import com.training_delivery.demo.model.store.entity.Store;
import com.training_delivery.demo.model.store.entity.StoreCategory;
import com.training_delivery.demo.model.store.entity.StoreCategoryMapping;
import com.training_delivery.demo.model.store.repository.StoreCategoryMapping.StoreCategoryMappingRepository;
import com.training_delivery.demo.model.store.repository.location.LocationRepository;
import com.training_delivery.demo.model.store.repository.store.StoreRepository;
import com.training_delivery.demo.model.store.repository.storeCategory.StoreCategoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final LocationRepository locationRepository;
    private final StoreCategoryRepository storeCategoryRepository;
    private final StoreCategoryMappingRepository storeCategoryMappingRepository;

    @Transactional
    public void registerStore(StoreRegisterRequestDto requestDto, String userId) {
        Location saveLocation = Location.builder()
                .zipcode(requestDto.getStoreLocation().getZipCode())
                .address(requestDto.getStoreLocation().getAddress())
                .seoulAreaCode(SeoulAreaCode.fromNumber(requestDto.getStoreLocation().getSeoulRegionCode()))
                .build();

        Location savedLocation = locationRepository.save(saveLocation);


        Store store = Store.builder()
                .storeName(requestDto.getStoreName())
                .phoneNumber(requestDto.getPhoneNumber())
                .storeDescription(requestDto.getStoreDescription())
                .location(savedLocation)
                .build();

        store = storeRepository.save(store);

    }

    @Transactional
    public void deleteStroe(UUID id, String userId) {

        Store store = storeRepository.findByStoreUuid(id);
        if (store == null) {
            throw new RuntimeException("매장을 찾을 수 없습니다.");
        }

        storeRepository.delete(store);
    }

    @Transactional
    public void updateStore(StoreUpdateRequestDto requestDto, String userId, UUID id) {
        Store store = storeRepository.findByStoreUuid(id);
        if (store == null) {
            throw new RuntimeException("해당 매장을 찾을 수 없습니다.");
        }


        store.getCategoryMappings().forEach(mapping -> mapping.setDeleted(true));

        storeCategoryMappingRepository.saveAll(store.getCategoryMappings());

        List<StoreCategory> storeCategoryList = requestDto.getStoreCategoryId().stream()
                .map(
                        category -> StoreCategory.builder()
                                .storeType(StoreType.fromNumber(category))
                                .build()
                ).toList();

        List<StoreCategory> savedStoreCategory = storeCategoryRepository.saveAll(storeCategoryList);

        //  StoreCategoryMapping 생성 및 저장
        List<StoreCategoryMapping> storeCategoryMappingList = savedStoreCategory.stream().map(
                category -> StoreCategoryMapping.builder()
                        .store(store)
                        .storeCategory(category)
                        .build()
        ).toList();
        List<StoreCategoryMapping> categoryMappingList = storeCategoryMappingRepository.saveAll(storeCategoryMappingList);
        store.getCategoryMappings().addAll(categoryMappingList);
    }




}
