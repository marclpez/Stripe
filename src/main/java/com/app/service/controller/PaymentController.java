package com.app.service.controller;

import com.app.service.dto.BalanceDto;
import com.app.service.dto.StripeDto;
import com.app.service.mapper.BalanceMapper;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Balance;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/stripe")
@CrossOrigin(origins = "*")
public class PaymentController {

    private final BalanceMapper balanceMapper;

    @GetMapping("/balance")
    public BalanceDto getBalanceAccount() throws StripeException {
        log.info("Check balance amount in the account");
        Balance balanceAccount = Balance.retrieve();
        return balanceMapper.map(balanceAccount);
    }

    @PostMapping
    public void checkDataInStripe(@RequestBody @Valid StripeDto stripeDto) {
        
    }

}
