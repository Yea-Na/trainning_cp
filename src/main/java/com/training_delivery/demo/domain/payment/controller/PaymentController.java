package com.training_delivery.demo.domain.payment.controller;

import com.training_delivery.demo.domain.payment.dto.request.PaymentCancelRequestDto;
import com.training_delivery.demo.domain.payment.dto.request.PaymentConfirmRequestDto;
import com.training_delivery.demo.domain.payment.dto.response.PaymentCancelResponseDto;
import com.training_delivery.demo.domain.payment.dto.response.PaymentConfirmResponseDto;
import com.training_delivery.demo.domain.payment.dto.response.PaymentSearchResponseDto;
import com.training_delivery.demo.domain.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedModel;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/v1/payment/confirm")
    public CustomResponse<PaymentConfirmResponseDto>confirmPayment(
            @AuthenticationPrincipal CustomUesrDetail uesrDetail,
            @RequestBody PaymentConfirmRequestDto paymentConfirmRequestDto
    ){
        PaymentConfirmRequestDto response = paymentService.confirmPayment(userDetail, request);
        return CustomResponse.success(ResponseMessage.PAYMENT_REQUEST.getMessage(), response);
    }

    @PostMapping("/v1/payment/{paymentId}/cancel")
    public CustomResponse<PaymentCancelResponseDto> cancelPayment(
            @PathVariable UUID paymentId,
            @RequestBody PaymentCancelRequestDto request
    ) {
        PaymentCancelResponseDto response = paymentService.cancelPayment(paymentId, request);
        return CustomResponse.success(ResponseMessage.PAYMENT_CANCEL.getMessage(), response);
    }

    @GetMapping("/v1/payment/{paymentId}")
    public CustomResponse<PaymentSearchResponseDto> searchPayment(@PathVariable UUID paymentId) {
        PaymentSearchResponseDto response = paymentService.searchPayment(paymentId);
        return CustomResponse.success(ResponseMessage.PAYMENT_SEARCH.getMessage(), response);
    }

    @GetMapping("/v1/payments")
    public CustomResponse<PagedModel<PaymentSearchResponseDto>> searchPayment(
            @AuthenticationPrincipal CustomUserDetail userDetail,
            @PageableDefault(direction = Sort.Direction.DESC, size = 10) Pageable pageable) {
        PagedModel<PaymentSearchResponseDto> response = paymentService.searchPayments(userDetail.getUserId(), pageable);
        return CustomResponse.success(ResponseMessage.PAYMENT_SEARCH_ALL.getMessage(), response);
    }
}
