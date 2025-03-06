package com.training_delivery.demo.domain.store.service;

import com.training_delivery.demo.domain.store.dto.request.StoreRegisterRequestDto;
import com.training_delivery.demo.model.store.constant.SeoulAreaCode;
import com.training_delivery.demo.model.store.entity.Location;
import com.training_delivery.demo.model.store.entity.Store;
import com.training_delivery.demo.model.store.repository.location.LocationRepository;
import com.training_delivery.demo.model.store.repository.store.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final LocationRepository locationRepository;

    @Override
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
}
