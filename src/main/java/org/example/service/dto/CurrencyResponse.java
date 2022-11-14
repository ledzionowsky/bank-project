package org.example.service.dto;

import lombok.Data;

import java.util.Map;
@Data
public class CurrencyResponse {
    private String base;
    private String date;
    private Map<String,Double> rates;
}
