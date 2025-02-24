package com.training_delivery.demo.domain.ai.controller;

import com.training_delivery.demo.domain.ai.service.AiService;
import com.training_delivery.demo.domain.ai.service.AiServiceImpl;
import com.training_delivery.demo.model.ai.repository.AiJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ai")
public class AiController {

    private final AiService aiService;

    @PostMapping("/generate")
    public String generateContent(@RequestParam Map<String, Object> requestData,
                                  @AuthenticationPrincipal UserDetails userDetails) {


        return aiService.generateContent();
    }



}
