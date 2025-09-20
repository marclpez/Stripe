package com.app.service.dto;

import lombok.Data;

import java.util.Currency;

@Data
public class StripeDto {
    private int amount;

    private String stripePublicKey;

    private Currency currency;
}
