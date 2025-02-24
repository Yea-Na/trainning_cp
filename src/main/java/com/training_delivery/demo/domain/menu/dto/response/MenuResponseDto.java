package com.training_delivery.demo.domain.menu.dto.response;

import com.training_delivery.demo.model.menu.entity.Menu;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class MenuResponseDto {
    private UUID menuUuid;
    private UUID storeUuid;
    private String foodName;
    private String description;
    private int price;
    private boolean availability;
    private String foodImage;

    public static MenuResponseDto from(Menu menu) {
        return MenuResponseDto.builder()
                .menuUuid(menu.getMenuUuId())
                .storeUuid(menu.getStore() != null ? menu.getStore().getStoreUuid() : null)
                .foodName(menu.getMenuName())
                .description(menu.getMenuDescription())
                .price(menu.getMenuPrice())
                .availability(menu.isMenuAvailability())
                .foodImage(menu.getFoodImage())
                .build();
    }

}
