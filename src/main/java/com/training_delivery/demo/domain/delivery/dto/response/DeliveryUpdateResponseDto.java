package com.training_delivery.demo.domain.delivery.dto.response;

import java.time.LocalDateTime;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryUpdateResponseDto {

	private String orderId;
	private String deliveryStatus;
	private LocalDateTime deliveryStartTime;
	private LocalDateTime deliveryEstimatedTime;

}
