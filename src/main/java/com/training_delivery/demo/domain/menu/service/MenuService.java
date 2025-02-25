package com.training_delivery.demo.domain.menu.service;

import com.training_delivery.demo.domain.menu.dto.request.MenuCreateRequestDto;
import com.training_delivery.demo.domain.menu.dto.request.MenuUpdateRequestDto;
import com.training_delivery.demo.domain.menu.dto.response.MenuResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface MenuService {
    void registerMenu(String userId, UUID storeUuid, MenuCreateRequestDto requestDto, MultipartFile foodImage);


    void deleteMenu(String userId, UUID storeUuid);


    void updateMenu(UUID menuUuid, MenuUpdateRequestDto requestDto, MultipartFile foodImage);

    MenuResponseDto getMneu(String userId, UUID menuUuid);

    Page<MenuResponseDto> searchMenus(UUID storeUuid, String search, Pageable pageable);
}
