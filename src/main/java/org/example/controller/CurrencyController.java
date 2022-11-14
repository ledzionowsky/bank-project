package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.service.CurrencyService;
import org.example.service.dto.CurrencyResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CurrencyController {
    private final CurrencyService service;
    @GetMapping(path = "/api/currency")
    public ResponseEntity<CurrencyResponse> getCurrencyRates(){
        final CurrencyResponse currencyResponse = service.getCurrencyRates();
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("apikey", "rXVvAjNPYHcWSGvItQYZJSFJvJbHmRlh");
        return new ResponseEntity<>(currencyResponse,httpHeaders, HttpStatus.ACCEPTED);
    }
}
