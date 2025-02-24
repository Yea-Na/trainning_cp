package com.training_delivery.demo.domain.review.dto.response;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewCreateResponseDto {
    private UUID reviewId;

    public static ReviewCreateResponseDto from(UUID reviewId) {
        return new ReviewCreateResponseDto(reviewId);

    }
}
