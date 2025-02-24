package com.training_delivery.demo.domain.delivery.dto.response;


import com.training_delivery.demo.model.delivery.entity.Delivery;
import com.training_delivery.demo.model.delivery.entity.DeliveryStatus;
import com.training_delivery.demo.model.order.entity.Order;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliverySearchResponseDto {

	private UUID orderId;
	private LocalDateTime orderCreatedAt;
	private UUID deliveryId;
	private String deliveryAddress;
	private DeliveryStatus deliveryStatus;
	private LocalDateTime deliveryStartTime;
	private int estimatedDeliveryTime;

//	public static DeliverySearchResponseDto of(Order order, Delivery delivery) {
//		return DeliverySearchResponseDto.builder()
//				.orderId(order.getOrderUuid())
//				.orderCreatedAt(order.getCreatedAt())
//				.deliveryId(delivery.getDeliveryUuid())
//				.deliveryAddress(order.getDeliveryAddress())
//				.deliveryStatus(delivery.getStatus())
//				.deliveryStartTime(delivery.getDeliveryStartTime())
//				.estimatedDeliveryTime(delivery.getDeliveryArrivalTime())
//				.build();
//	}
}
