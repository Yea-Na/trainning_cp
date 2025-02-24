package com.training_delivery.demo.domain.delivery.controller;

import com.training_delivery.demo.domain.delivery.dto.request.DeliveryCompleteRequestDto;
import com.training_delivery.demo.domain.delivery.dto.request.DeliveryStartRequestDto;
import com.training_delivery.demo.domain.delivery.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DeliveryController {
    private DeliveryService deliveryService;

    @PatchMapping("v1/delivery/{deliveryId}/start")
    public void startDelivery(
            @PathVariable("deliveryId") UUID deliveryId,
            @RequestBody DeliveryStartRequestDto request) {

    }

    @PatchMapping("/v1/deliveries/{deliveryId}/complete")
    public CustomResponse<com.server.delivery.domain.delivery.dto.res.DeliveryCompleteResponseDto> completeDelivery(
            @PathVariable UUID deliveryId,
            @RequestBody DeliveryCompleteRequestDto request
    ) {

    }


}
