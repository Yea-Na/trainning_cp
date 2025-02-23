package com.training_delivery.demo.model.payment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Embeddable
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentCancelDetails {
	@Column(name = "payment_canceled_at")
	private ZonedDateTime canceledAt;

	@Column(name = "payment_cancel_reason")
	private String cancelReason;

	@Column(name = "payment_cancel_transaction_Ic")
	private String cancelTransactionKey;
}
