package com.training_delivery.demo.domain.delivery.dto.response;


import com.training_delivery.demo.model.delivery.entity.Delivery;
import com.training_delivery.demo.model.order.entity.Order;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryStartResponseDto {

	private OrderInfo orderInfo;
	private DeliveryInfo deliveryInfo;

	public static DeliveryStartResponseDto from(Delivery delivery, Order order) {
		return DeliveryStartResponseDto.builder()
				.orderInfo(OrderInfo.from(order))
				.deliveryInfo(DeliveryInfo.from(delivery))
				.build();
	}
}
