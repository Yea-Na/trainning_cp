package com.training_delivery.demo.domain.payment.client.dto;

import com.training_delivery.demo.model.payment.entity.PaymentMethod;
import com.training_delivery.demo.model.payment.entity.PaymentStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentConfirmOutput {
    private String paymentKey;
    private UUID serverOrderId;
    private String transactionKey;
    private BigDecimal totalAmount;
    private PaymentMethod paymentMethod;
    private ZonedDateTime requestedAt;
    private ZonedDateTime approvedAt;
    private PaymentStatus status;
}

