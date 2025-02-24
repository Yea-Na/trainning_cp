package com.training_delivery.demo.domain.payment.dto.response;

import com.training_delivery.demo.model.payment.entity.Payment;
import com.training_delivery.demo.model.payment.entity.PaymentCancelDetails;
import com.training_delivery.demo.model.payment.entity.PaymentMethod;
import com.training_delivery.demo.model.payment.entity.PaymentStatus;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentSearchResponseDto {
    private UUID paymentId;
    private UUID orderId;
    private String transactionKey;
    private BigDecimal totalAmount;
    private PaymentMethod paymentMethod;
    private PaymentStatus status;
    private LocalDateTime orderedAt;
    private ZonedDateTime paidAt;
    private ZonedDateTime canceledAt;

    public static PaymentSearchResponseDto from(Payment payment) {
        PaymentCancelDetails cancelDetails = payment.getCancelDetails();
        return PaymentSearchResponseDto.builder()
                .paymentId(payment.getId())
                .orderId(payment.getOrder().getOrderUuid())
                .transactionKey(payment.getTransactionKey())
                .totalAmount(payment.getAmount())
                .paymentMethod(payment.getPaymentMethod())
                .status(payment.getStatus())
                .orderedAt(payment.getOrder().getCreatedAt())
                .paidAt(payment.getPaidAt())
                .canceledAt(cancelDetails != null ? cancelDetails.getCanceledAt() : null)
                .build();
    }
}
