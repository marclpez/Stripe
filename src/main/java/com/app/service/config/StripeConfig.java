package com.app.service.config;

import com.stripe.Stripe;
import jakarta.annotation.PostConstruct;
import lombok.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StripeConfig {

//    @Value("${stripe.api.key}")
    private String apiKey;

    @PostConstruct
    public void init() {
        Stripe.apiKey = apiKey;
    }
}
