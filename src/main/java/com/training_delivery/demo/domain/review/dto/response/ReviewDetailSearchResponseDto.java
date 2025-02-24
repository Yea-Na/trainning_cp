package com.training_delivery.demo.domain.review.dto.response;

import java.time.LocalDateTime;
import java.util.List;


import com.training_delivery.demo.model.review.entity.Review;
import com.training_delivery.demo.model.review.entity.ReviewImage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDetailSearchResponseDto {

    private Double rating;
    private String content;
    private List<String> images;
    private LocalDateTime createdAt;
    private String createdBy;

    public static ReviewDetailSearchResponseDto from(Review review) {
        return ReviewDetailSearchResponseDto.builder()
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
