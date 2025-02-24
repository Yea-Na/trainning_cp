package com.training_delivery.demo.domain.review.dto.response;

import com.training_delivery.demo.model.review.entity.Review;
import com.training_delivery.demo.model.review.entity.ReviewImage;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoreReviewSearchResponseDto {

    private UUID reviewId;
    private Long userId;
    private Double rating;
    private String content;
    private List<String> images;
    private LocalDateTime createdAt;
    private String createdBy;

    public static StoreReviewSearchResponseDto from(Review review) {
        return StoreReviewSearchResponseDto.builder()
                .reviewId(review.getId())
                .userId(review.getUser().getId())
                .rating(review.getRating())
                .content(review.getContent())
                .images(review.getImages().stream()
                        .map(ReviewImage::getImageUrl)
                        .toList())
                .createdAt(review.getCreatedAt())
                .createdBy(review.getCreatedBy())
                .build();
    }
}
