package com.training_delivery.demo.domain.review.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewCreateRequestDto {

    private UUID orderId;
    private UUID storeUuid;
    private String content;
    private Double rating;

}

