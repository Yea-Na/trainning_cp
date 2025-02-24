package com.training_delivery.demo.domain.review.dto.response;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


import com.training_delivery.demo.model.review.entity.Review;
import com.training_delivery.demo.model.review.entity.ReviewImage;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserReviewSearchResponseDto {

    private UUID reviewId;
    private UUID storeUuid;
    private String storeName;
    private Double rating;
    private String content;
    private List<String> images;
    private LocalDateTime createdAt;
    private String createdBy;

    public static UserReviewSearchResponseDto from(Review review) {
        return UserReviewSearchResponseDto.builder()
                .reviewId(review.getId())
                .storeUuid(review.getStore().getStoreUuid())
                .storeName(review.getStore().getStoreName())
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
