package com.app.service.dto.request;

import com.app.service.enums.Currency;
import lombok.Data;

@Data
public class PaymentRequestDto {
    private Long amount;

    private String method;

    private Currency currency;
}
