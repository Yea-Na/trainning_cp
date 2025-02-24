package com.training_delivery.demo.domain.payment.dto.response;

import com.training_delivery.demo.model.payment.entity.Payment;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentConfirmResponseDto {
    private UUID paymentId;

    public static PaymentConfirmResponseDto from(Payment payment) {
        return PaymentConfirmResponseDto.builder()
                .paymentId(payment.getId())
                .build();
    }
}
