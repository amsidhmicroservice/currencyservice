package com.amsidh.mvc.currencyconversion.client;

import com.amsidh.mvc.currencyconversion.client.response.Exchange;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange", url = "${CURRENCY_EXCHANGE_URI:http://localhost}:8181")
//@FeignClient(name = "currency-exchange", url = "${CURRENCY_EXCHANGE_SERVICE_HOST:http://localhost}:8181") //It is not working
@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeService {
    //http://localhost:8181/currency-exchange/USD/to/INR
    @GetMapping(value = "/currency-exchange/{currencyFrom}/to/{currencyTo}")
    Exchange getExchange(@PathVariable("currencyFrom") String currencyFrom, @PathVariable("currencyTo") String currencyTo);
}

