package org.example.service;

import org.example.service.dto.CurrencyResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyService {
        public CurrencyResponse getCurrencyRates(){
            final RestTemplate restTemplate = new RestTemplate();
            final ResponseEntity<CurrencyResponse> response = restTemplate
                    .getForEntity("https://api.apilayer.com/exchangerates_data/latest?symbols=symbols&base=USD",
                            CurrencyResponse.class);
            return response.getBody();
        }
    }

