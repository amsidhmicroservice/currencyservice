package com.amsidh.mvc.currencyexchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.web.exchanges.HttpExchangeRepository;
import org.springframework.boot.actuate.web.exchanges.InMemoryHttpExchangeRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.amsidh.mvc"})
public class CurrencyExchangeApplication {
    public static void main(String[] args) {
        SpringApplication.run(CurrencyExchangeApplication.class, args);
    }
}
