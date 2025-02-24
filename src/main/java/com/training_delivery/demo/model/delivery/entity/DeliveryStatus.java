package com.training_delivery.demo.model.delivery.entity;

import lombok.Getter;

@Getter
public enum DeliveryStatus {
	WAITING,
	PICKUP,
	DELIVERING,
	COMPLETED,
	CANCELED
}
