package com.training_delivery.demo.domain.menu.service;

import com.training_delivery.demo.domain.menu.dto.request.MenuCreateRequestDto;
import com.training_delivery.demo.domain.menu.dto.request.MenuUpdateRequestDto;
import com.training_delivery.demo.domain.menu.dto.response.MenuResponseDto;
import com.training_delivery.demo.model.menu.entity.Menu;
import com.training_delivery.demo.model.menu.repository.MenuRepository;
import com.training_delivery.demo.model.store.entity.Store;
import com.training_delivery.demo.model.store.repository.StoreRepository;
import com.training_delivery.demo.model.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.*;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {
    private final MenuRepository menuRepository;
    private final StoreRepository storeRepository;
    private final UserRepository userRepository;


    @Transactional
    public void registerMenu(
            String userId,
            UUID storeUuid,
            MenuCreateRequestDto requestDto,
            MultipartFile foodImage) {
        String user = userId;
        Store store = storeRepository.findByUuid(storeUuid);
        String uploadedFoodImage = foodImage.getOriginalFilename();
        Menu menu = MenuCreateRequestDto.to(requestDto, store, uploadedFoodImage);

        menuRepository.save(menu);
    }

    @Override
    public void deleteMenu(String userId,
                           UUID storeUuid) {
        String user = userId;
        Store store = storeRepository.findByUuid(storeUuid);

        Menu menu = menuRepository.findByUuid(storeUuid);

        menu.setMenuAvailability(false);

        menuRepository.save(menu);

    }


    @Transactional
    public void updateMenu(
            UUID menuUuid,
            MenuUpdateRequestDto requestDto,
            MultipartFile foodImage
    ) {
        // 기존 메뉴 조회
        Menu existingMenu = menuRepository.findById(menuUuid)
                .orElseThrow(() -> new IllegalArgumentException("해당 메뉴가 존재하지 않습니다."));

        // 이미지 파일이 없으면 기존 이미지 유지
        String updatedFoodImage = existingMenu.getFoodImage();
        if (foodImage != null && !foodImage.isEmpty()) {
            updatedFoodImage = foodImage.getOriginalFilename(); // 실제 업로드 구현 시 변경 필요
        }

        // 메뉴 정보 업데이트 (빌더 사용)
        Menu updatedMenu = Menu.builder()
                .menuUuId(existingMenu.getMenuUuId())
                .menuName(requestDto.getFoodName())
                .menuDescription(requestDto.getDescription())
                .menuAvailability(requestDto.isAvailability())
                .menuPrice(requestDto.getPrice())
                .foodImage(updatedFoodImage)  // 이미지 반영
                .build();

        // 기존 데이터 업데이트 (새 객체 저장)
        menuRepository.save(updatedMenu);
    }

    @Transactional
    public MenuResponseDto getMneu(String userId, UUID menuUuid) {

        Menu menu = menuRepository.findByUuid(menuUuid);
        return MenuResponseDto.from(menu);
    }

    @Override
    public Page<MenuResponseDto> searchMenus(
            UUID storeUuid,
            String search,
            Pageable pageable) {

        Sort defaultSort = Sort.by(Sort.Order.desc("createdAt"), Sort.Order.desc("modifiedAt"));

        Pageable sortedPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), defaultSort);

        Store store = storeRepository.findByUuid(storeUuid);

        Page<Menu> menuList = menuRepository.findByStoreAndMenuNameContainingAndMenuAvailabilityTrue(store, search, pageable);

        return menuList.map(MenuResponseDto::from);
    }


}
