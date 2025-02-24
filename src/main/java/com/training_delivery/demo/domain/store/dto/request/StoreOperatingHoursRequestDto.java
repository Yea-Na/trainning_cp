package com.training_delivery.demo.domain.store.dto.request;

import com.training_delivery.demo.model.store.constant.WeekDays;
import com.training_delivery.demo.model.store.entity.OperationTimes;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StoreOperatingHoursRequestDto {
    private String operationTimeOpeningTime;
    private String operationTimeClosingTime;
    private boolean isHoliday;
    private int weekdays;

    public static OperationTimes from(StoreOperatingHoursRequestDto requestDto) {
        return OperationTimes.builder()
                .operationTimeClosingTime(requestDto.getOperationTimeClosingTime())
                .operationTimeOpeningTime(requestDto.getOperationTimeOpeningTime())
                .isHoliday(requestDto.isHoliday())
                .weekday(WeekDays.fromNumber(requestDto.getWeekdays()))
                .build();

    }
}
