package com.app.service.dto;

import lombok.Data;

import java.util.List;

@Data
public class BalanceDto {
    private List<Available> available;

    public record Available() {
        static Long amount;
        static String currency;
    }
}
