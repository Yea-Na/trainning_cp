package com.training_delivery.demo.domain.store.controller;

import com.training_delivery.demo.domain.store.dto.request.StoreOperatingHoursRequestDto;
import com.training_delivery.demo.domain.store.dto.response.StoreResponseDto;
import com.training_delivery.demo.domain.store.service.StoreService;
import com.training_delivery.demo.model.store.entity.StoreOperationTimes;
import com.training_delivery.demo.model.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/store")
public class StoreController {

    private final StoreService storeService;

    //매장 등록
    /*
    @PostMapping
    public CustomResponse<Void> registerStore(
            @RequestBody StoreRegisterRequestDto requestDto,
            @AuthenticationPrincipal CustomUserDetail userDetail
    ){

    }

    //매장 삭제
    @DeleteMapping("/{id}")
    public CustomResponse<Void> deleteStore(
            @PathVariable UUID id,
            @AuthenticationPrincipal CustomUserDetail userDetail
            ){

    }

    // 매장 정보 수정
    @PatchMapping("/{id}")
    public CustomResponse<Void> deleteStore(
            @PathVariable UUID id,
            @AuthenticationPrincipal CustomUserDetail userDetail){

    }

    //매장 단일 조회
    @GetMapping("/{storeUuid}")
    public CustomResponse<StoreResponseDto> getStore(
            @PathVariable UUID storeUuid
    ){

    }

    //매장 위치 수정
    @PatchMapping("/{storeUuid}/location")
    public CustomResponse<Void> updateStoreLocation(
            @PathVariable UUID storeUuid,
            @RequestBody StoreLocatoinRequestDto requestDto
    ){

    }

    //매장 영업 시간 수정
    @PatchMapping("/{storeUuid}/operationTime")
    public CustomResponse<Void> updateStoreOperatingHours(
            @PathVariable UUID storeUuid,
            @RequestBody List<StoreOperatingHoursRequestDto> requestDto
    ){

    }

    // 매장 검색
    @GetMapping
    public CustomResponse<PageCustom<StoreResponseDto>> searchStore(
            @RequestParam("search") String search,
            @PageableDefault Pageable pageable,
            @AuthenticationPrincipal CustomUserDetail
    ){

    }

    CustomResponse 생성...후
*/

}
