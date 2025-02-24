package com.training_delivery.demo.domain.review.controller;

import com.training_delivery.demo.domain.review.dto.request.ReviewCreateRequestDto;
import com.training_delivery.demo.domain.review.dto.request.ReviewUpdateRequestDto;
import com.training_delivery.demo.domain.review.dto.response.*;
import com.training_delivery.demo.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;


    @PostMapping("/v1/review")
    public CustomResponse<ReviewCreateResponseDto>createReview(
            @AuthenticationPrincipal CustomUserDetail userDetail,
            @RequestPart("review") ReviewCreateRequestDto request
    ){

    }


    @PatchMapping("/v1/reivew/{reviewId}")
    public CustomResponse<ReviewUpdateResponseDto> updateReview(
            @PathVariable UUID reviewId,
            @RequestPart("review") ReviewUpdateRequestDto request,
            @RequestPart(value = "reviewImage", required = false) List<MultipartFile> image
    ){

    }


    @GetMapping("/v1/reviews/{reviewId}")
    public CustomResponse<ReviewDetailSearchResponseDto> searchReview(@PathVariable UUID reviewId) {

    }

    @GetMapping("/v1/review/store/{storeId}")
    public CustomResponse<PagedModel<StoreReviewSearchResponseDto>> searchStoreReviews(
            @PathVariable UUID storeId,
            @RequestParam(required = false) String keyword,
            @PageableDefault(sort = {"createAt"}, direction = Sort.Direction.DESC, size = 10) Pageable pageable){

    }

    @GetMapping("/v1/user/{userId}/review")
    public CustomResponse<PagedModel<UserReviewSearchResponseDto>> searchUserReviews(
            @AuthenticationPrincipal CustomUserDetail userDetail,
            @RequestParam(required = false) String keyword,
            @PageableDefault(sort = {"creatAt"}, direction = Sort.Direction.DESC, size = 10) Pageable pageable
    ){

    }

    @DeleteMapping("/v1/reivew/{reviewId}")
    public CustomResponse<Void> delete(@PathVariable UUID reviewId){

    }

}
