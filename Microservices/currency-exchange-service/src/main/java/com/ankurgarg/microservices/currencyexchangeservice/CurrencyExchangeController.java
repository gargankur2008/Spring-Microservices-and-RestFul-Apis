package com.ankurgarg.microservices.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Arrays;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private ExchangeValueRepository repository;

    @GetMapping("/bulkcreate")
    public void bulkCreate() {
        repository.saveAll((Arrays.asList(
                new ExchangeValue(1,"USD","INR",BigDecimal.valueOf(75)),
                new ExchangeValue(2,"EUR","INR",BigDecimal.valueOf(85)),
                new ExchangeValue(3,"CAD","INR", BigDecimal.valueOf(55))
        )));

    }

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to){
        ExchangeValue value = repository.findByFromAndTo(from,to);
        return value;
    }

    @GetMapping("/currency-exchange-feign/from/{from}/to/{to}")
    public ExchangeValue retrieveFeignExchangeValue(@PathVariable String from, @PathVariable String to){
        ExchangeValue value = repository.findByFromAndTo(from,to);
        return value;
    }
}
