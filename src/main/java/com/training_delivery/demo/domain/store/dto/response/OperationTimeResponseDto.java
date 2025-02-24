package com.training_delivery.demo.domain.store.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OperationTimeResponseDto {
    private String days;
    private String openTime;
    private String closeTime;
    private boolean isHoliday;
}
