package com.amsidh.mvc.currencyconversion.controller;

import com.amsidh.mvc.currencyconversion.client.CurrencyExchangeService;
import com.amsidh.mvc.currencyconversion.client.response.Exchange;
import com.amsidh.mvc.currencyconversion.response.CurrencyConversionResponse;
import com.amsidh.mvc.currencyconversion.service.InstanceInformationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RequiredArgsConstructor
@RestController
@Slf4j
public class ConversionController {

    private final CurrencyExchangeService currencyExchangeService;
    private final InstanceInformationService instanceInformationService;

    @GetMapping(value = {"/currency-conversion/from/{currencyFrom}/to/{currencyTo}/quantity/{quantity}"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public CurrencyConversionResponse convertCurrency(@PathVariable("currencyFrom") String currencyFrom, @PathVariable("currencyTo") String currencyTo, @PathVariable("quantity") BigDecimal quantity) {
       log.info("Inside convertCurrency method of ConversionController!!!");
        Exchange exchange = currencyExchangeService.getExchange(currencyFrom, currencyTo);
        CurrencyConversionResponse currencyConversionResponse = CurrencyConversionResponse.builder()
                .id(exchange.getId())
                .from(exchange.getCurrencyFrom())
                .to(exchange.getCurrencyTo())
                .conversionMultiple(exchange.getConversionMultiple())
                .quantity(quantity)
                .conversionEnvironmentInfo(instanceInformationService.retrieveInstanceInfo())
                .exchangeEnvironmentInfo(exchange.getExchangeEnvironmentInfo())
                .totalCalculatedAmount(quantity.multiply(exchange.getConversionMultiple()))
                .build();
        return currencyConversionResponse;
    }
}
