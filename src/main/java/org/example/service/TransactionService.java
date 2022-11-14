package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.controller.dto.TransactionRequest;
import org.example.repository.TransactionRepository;
import org.example.repository.entity.TransactionEntity;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository repository;
    private final AccountService accountService;

    public void createTransaction(TransactionRequest request){
        accountService.transfer(
                request.getFromAccountId(),
                request.getToAccountId(),
                request.getAmount()
        );

        repository.save(
                TransactionEntity.builder()
                        .amount(request.getAmount())
                        .currency(request.getCurrency())
                        .fromAccountId(request.getFromAccountId())
                        .toAccountId(request.getToAccountId())
                        .transactionDate(
                                OffsetDateTime.now())
                        .build()
        );
    }
}
