package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.controller.dto.TransactionRequest;
import org.example.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TransactionController {
    private final TransactionService service;

    @PostMapping(path = "/api/transaction")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createTransaction(@RequestBody TransactionRequest request){
        service.createTransaction(request);
    }
}
