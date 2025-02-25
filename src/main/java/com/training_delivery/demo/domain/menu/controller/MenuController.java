package com.training_delivery.demo.domain.menu.controller;

import com.training_delivery.demo.common.response.CustomResponse;
import com.training_delivery.demo.domain.menu.dto.request.MenuCreateRequestDto;
import com.training_delivery.demo.domain.menu.dto.request.MenuUpdateRequestDto;
import com.training_delivery.demo.domain.menu.dto.response.MenuResponseDto;
import com.training_delivery.demo.domain.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/menus")
public class MenuController {

    private final MenuService menuService;

    //메뉴 등록
    @PostMapping("/{storeUuid}")
    public CustomResponse<Void> registerMenu(
            @PathVariable UUID storeUuid,
            @RequestPart("menuData") MenuCreateRequestDto requestDto,
            @RequestPart(value = "foodImage", required = false) MultipartFile foodImage,
            //@AuthenticationPrincipal CustomUserDetail customUserDetail
            String userId
            ){
        menuService.registerMenu(userId, storeUuid, requestDto, foodImage);

        return CustomResponse.success("성공");
    }

    //메뉴 수정
    @PutMapping("/{menuUuid}/menu")
    public CustomResponse<Void> updatemenu(
            @PathVariable UUID menuUuid,
            @RequestPart MenuUpdateRequestDto requestDto,
            @RequestPart(value = "foodImage", required = false) MultipartFile foodImage
          //  @AuthenticationPrincipal CustomUserDetail userDetail
            ){
        menuService.updateMenu(menuUuid, requestDto, foodImage);
        return CustomResponse.success("성공");
    }

    //메뉴 삭제
    @DeleteMapping("/{menuUuid}/menu")
    public CustomResponse<Void> deleteMenu(
            //@AuthenticationPrincipal CustomUserDetail customUserDetail,
            String userId,
            @PathVariable UUID menuUuid
    ){
        menuService.deleteMenu(userId, menuUuid);
        return CustomResponse.success("성공");
    }





    //메뉴 단일 조회
    @GetMapping("/{menuUuid}/menu")
    public CustomResponse<MenuResponseDto> getMenu(
            //@AuthenticationPrincipal CustomUserDetail customUserDetail,
            String userId,
            @PathVariable UUID menuUuid
    ){
        MenuResponseDto response = menuService.getMneu(userId, menuUuid);

        return CustomResponse.success("성공", response);
    }


    //메뉴 검색
    @GetMapping("/{storeUuid}/store")
    public CustomResponse<Page<MenuResponseDto>> searchMenus(
            @PathVariable UUID storeUuid,
            @RequestParam("search") String search,
            @PageableDefault(size = 10, sort = "menuName", direction = Sort.Direction.ASC) Pageable pageable
            //@AuthenticationPrincipal CustomUserDetail customUserDetail
    ){
        Page<MenuResponseDto> menus = menuService.searchMenus(storeUuid, search, pageable);
        return CustomResponse.success("성공",menus);
    }

}
