package com.app.service.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class BalanceResponseDto {
    private List<Available> available;

    public record Available() {
        static Long amount;
        static String currency;
    }
}
