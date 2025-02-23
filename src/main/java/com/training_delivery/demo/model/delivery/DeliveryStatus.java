package com.training_delivery.demo.model.delivery;

import lombok.Getter;

@Getter
public enum DeliveryStatus {
	WAITING,
	PICKUP,
	DELIVERING,
	COMPLETED,
	CANCELED
}
