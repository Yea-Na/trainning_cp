package com.training_delivery.demo.domain.delivery.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;


import com.training_delivery.demo.model.delivery.entity.Delivery;
import com.training_delivery.demo.model.delivery.entity.DeliveryStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryInfo {

    private UUID deliveryUuid;
    private DeliveryStatus deliveryStatus;
    private LocalDateTime deliveryStartTime;
    private Integer deliveryArrivalTime;

    public static DeliveryInfo from(Delivery delivery) {
        return DeliveryInfo.builder()
                .deliveryUuid(delivery.getId())
                .deliveryStatus(delivery.getStatus())
                .deliveryStartTime(delivery.getDeliveryStartTime())
                .deliveryArrivalTime(delivery.getDeliveryArrivalTime())
                .build();
    }
}
