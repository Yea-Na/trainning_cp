package com.training_delivery.demo.domain.menu.controller;

import com.training_delivery.demo.domain.menu.dto.request.MenuCreateRequestDto;
import com.training_delivery.demo.domain.menu.dto.request.MenuUpdateRequestDto;
import com.training_delivery.demo.model.menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
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
            @AuthenticationPrincipal CustomUserDetail customUserDetail
            ){

    }

    //메뉴 수정
    @PutMapping("/{menuUuid}/menu")
    public CustomResponse<Void> updatemenu(
            @PathVariable UUID menuUuid,
            @RequestPart MenuUpdateRequestDto requestDto,
            @RequestPart MultipartFile foodImage,
            @AuthenticationPrincipal CustomUserDetail userDetail
            ){

    }

    //메뉴 삭제
    @DeleteMapping("/{menuUuid}/menu")
    public CustomResponse<Void> deleteMenu(
            @AuthenticationPrincipal CustomUserDetail customUserDetail,
            @PathVariable UUID menuUuid
    ){

    }

    //메뉴 단일 조회
    @DeleteMapping("/{menuUuid}/menu")
    public CustomResponse<Void> deleteMenu(
            @AuthenticationPrincipal CustomUserDetail customUserDetail,
            @PathVariable UUID menuUuid
    ){


    }

    //메뉴 단일 조회
    @GetMapping("/{menuUuid}/menu")
    public CustomResponse<MenuResponsDto> getMenu(
            @AuthenticationPrincipal CustomUserDetail customUserDetail,
            @PathVariable UUID menuUuid
    ){

    }

    //메뉴 검색
    @GetMapping("/{storeUuid}/store")
    public CustomResponse<PageCustom<MenuResponseDto>> searchMenus(
            @PathVariable UUID storeUuid,
            @RequestParam("search") String search,
            @PageableDefault Pageable pageable,
            @AuthenticationPrincipal CustomUserDetail customUserDetail
    ){

    }

}
