package com.training_delivery.demo.domain.review.dto.response;

import com.training_delivery.demo.model.review.entity.Review;
import com.training_delivery.demo.model.review.entity.ReviewImage;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewUpdateResponseDto {

    private Double rating;
    private String content;
    private List<String> images;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime modifiedAt;
    private String modifiedBy;

    public static ReviewUpdateResponseDto from(Review review) {
        return ReviewUpdateResponseDto.builder()
                .rating(review.getRating())
                .content(review.getContent())
                .images(review.getImages().stream()
                        .map(ReviewImage::getImageUrl)
                        .toList())
                .createdAt(review.getCreatedAt())
                .createdBy(review.getCreatedBy())
                .modifiedAt(review.getModifiedAt())
                .modifiedBy(review.getModifiedBy())
                .build();
    }
}
