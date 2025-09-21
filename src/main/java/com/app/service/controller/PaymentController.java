package com.app.service.controller;

import com.app.service.dto.response.BalanceResponseDto;
import com.app.service.dto.response.PaymentResponseDto;
import com.app.service.dto.request.PaymentRequestDto;
import com.app.service.mapper.BalanceMapper;
import com.stripe.exception.StripeException;
import com.stripe.model.Balance;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/payments")
@CrossOrigin(origins = "*")
public class PaymentController {

    private final BalanceMapper balanceMapper;

    @GetMapping
    public BalanceResponseDto getBalanceAccount() throws StripeException {
        log.info("Check balance amount in the account");
        Balance balanceAccount = Balance.retrieve();
        return balanceMapper.map(balanceAccount);
    }

    @PostMapping
    public PaymentResponseDto createPayment(@RequestBody @Valid PaymentRequestDto paymentRequestDto) throws StripeException {
        log.info("Send money to the account");
        PaymentIntentCreateParams params =
                PaymentIntentCreateParams.builder()
                        .setAmount(paymentRequestDto.getAmount())
                        .addAllPaymentMethodType(List.of("card"))
                        .setPaymentMethod(paymentRequestDto.getMethod())
                        .setCurrency(paymentRequestDto.getCurrency().toString())
                        .setConfirm(true)
                        .build();

        PaymentIntent intent = PaymentIntent.create(params);
        return PaymentResponseDto.builder().status(intent.getStatus()).build();
    }

}
