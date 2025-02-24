package com.training_delivery.demo.domain.delivery.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class DeliveryCompleteRequestDto{
    private UUID deliveryId;
}
