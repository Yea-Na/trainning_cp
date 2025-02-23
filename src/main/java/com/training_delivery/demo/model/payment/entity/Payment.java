package com.training_delivery.demo.model.payment.entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "p_payment")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "payment_id")
	private UUID id;

	@Column(name = "payment_amount")
	private BigDecimal amount;

	@Enumerated(EnumType.STRING)
	@Column(name = "payment_method")
	private PaymentMethod paymentMethod;

	@Enumerated(EnumType.STRING)
	@Column(name = "payment_status")
	private PaymentStatus status = PaymentStatus.PENDING;

	@Column(name = "payment_transaction_id", unique = true)
	private String transactionKey;

	@Column(unique = true)
	private String paymentKey;

	@OneToOne
	@JoinColumn(name = "order_uuid")
	private Order order;

	@ManyToOne
	@JoinColumn(name = "user_uuid")
	private User user;

	@Column(name = "payment_request_at")
	private ZonedDateTime requestedAt;

	@Column(name = "payment_paid_at")
	private ZonedDateTime paidAt;

	@Embedded
	private PaymentCancelDetails cancelDetails;

}
