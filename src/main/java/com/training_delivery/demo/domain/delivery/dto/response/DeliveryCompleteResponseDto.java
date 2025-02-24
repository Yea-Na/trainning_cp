package com.server.delivery.domain.delivery.dto.res;

import java.util.UUID;


import com.training_delivery.demo.model.delivery.entity.Delivery;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryCompleteResponseDto {

//	private OrderInfo orderInfo;
	private UUID deliveryId;
//
//	public static DeliveryCompleteResponseDto from(Delivery delivery, Order order) {
//		return DeliveryCompleteResponseDto.builder()
//				.orderInfo(OrderInfo.from(order))
//				.deliveryId(delivery.getDeliveryUuid())
//				.build();
//	}
}
