package com.training_delivery.demo.domain.store.controller;

import com.training_delivery.demo.common.response.CustomResponse;
import com.training_delivery.demo.domain.store.dto.request.StoreRegisterRequestDto;
import com.training_delivery.demo.domain.store.dto.request.StoreUpdateRequestDto;
import com.training_delivery.demo.domain.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/store")
public class StoreController {

    private final StoreService storeService;

    //매장 등록

    @PostMapping
    public CustomResponse<Void> registerStore(
            @RequestBody StoreRegisterRequestDto requestDto
            //, String userId
            //@AuthenticationPrincipal CustomUserDetail userDetail
    ){
        String userId = "admin";
        storeService.registerStore(requestDto, userId);

        return CustomResponse.success("성공");
    }

   //매장 삭제
    @DeleteMapping("/{id}")
    public CustomResponse<Void> deleteStore(
            @PathVariable UUID id
            //String userId
            // @AuthenticationPrincipal CustomUserDetail userDetail
            ){
        String userId = "admin";
        storeService.deleteStroe(id, userId);
        return CustomResponse.success("삭제 성공");
    }

   // 매장 정보 수정
    @PatchMapping("/{id}")
    public CustomResponse<Void> updateStore(
            @RequestBody StoreUpdateRequestDto requestDto,
            @PathVariable UUID id
            //, String userId
    //@AuthenticationPrincipal CustomUserDetail userDetail
    )
    {
        String userId = "admin";
        storeService.updateStore(requestDto, userId , id);
        return CustomResponse.success("수정 성공");
    }

/*    //매장 단일 조회
    @GetMapping("/{storeUuid}")
    public CustomResponse<StoreResponseDto> getStore(
            @PathVariable UUID storeUuid
    ){

    }

    //매장 위치 수정
    @PatchMapping("/{storeUuid}/location")
    public CustomResponse<Void> updateStoreLocation(
            @PathVariable UUID storeUuid,
            //@RequestBody StoreLocatoinRequestDto requestDto
            String userId

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
            //@AuthenticationPrincipal CustomUserDetail
            String userId

    ){

    }*/



}
