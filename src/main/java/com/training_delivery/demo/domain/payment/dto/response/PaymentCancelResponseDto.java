package com.training_delivery.demo.domain.payment.dto.response;

import com.training_delivery.demo.model.payment.entity.Payment;
import com.training_delivery.demo.model.payment.entity.PaymentCancelDetails;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentCancelResponseDto {

    private UUID paymentId;
    private String paymentKey;
    private ZonedDateTime canceledAt;
    private String lastTransactionKey;
    private String cancelTransactionKey;

    public static PaymentCancelResponseDto from(Payment payment) {
        PaymentCancelDetails cancelDetails = payment.getCancelDetails();
        return PaymentCancelResponseDto.builder()
                .paymentId(payment.getId())
                .paymentKey(payment.getPaymentKey())
                .canceledAt(cancelDetails.getCanceledAt())
                .lastTransactionKey(payment.getTransactionKey())
                .cancelTransactionKey(cancelDetails.getCancelTransactionKey())
                .build();
    }
}
