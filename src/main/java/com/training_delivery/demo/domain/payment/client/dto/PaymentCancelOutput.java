package com.training_delivery.demo.domain.payment.client.dto;

import com.training_delivery.demo.model.payment.entity.PaymentStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.ZonedDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentCancelOutput {
    private String paymentKey;
    private String lastTransactionKey;
    private PaymentStatus status;
    private Cancels cancels;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Cancels {
        private String cancelTransactionKey;
        private String cancelReason;
        private ZonedDateTime canceledAt;
    }
}
