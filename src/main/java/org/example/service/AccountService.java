package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.controller.dto.AccountRequest;
import org.example.controller.dto.AccountResponse;
import org.example.repository.AccountRepository;
import org.example.repository.entity.Account;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository  repository;
    public AccountResponse find(long id) {
        return repository
                .findById(id)
                .map(account ->
                        AccountResponse.builder()
                                .balance(account.getBalance())
                                .currency(account.getCurrency())
                                .userId(account.getUserId())
                                .id(account.getId())
                                .build()
                )
                .orElseThrow(()-> new IllegalArgumentException(
                        "Account with id: "+id+ " not found"));

    }

    public void save( AccountRequest account) {
        repository.save(
                Account.builder()
                        .balance(account.getBalance())
                        .userId(account.getUserId())
                        .currency(account.getCurrency())
                        .build()
        );

    }

        public void transfer(long fromAccountId, long toAccountId, double amount){

        validateAmount(amount);
        if (fromAccountId==(toAccountId)){
            throw new IllegalArgumentException("fromAccountId and toAccountId cant be equal");
        }

        Account fromAccount = repository.getOne(fromAccountId);
        Account toAccount = repository.getOne(toAccountId);


        if (fromAccount.getBalance() -amount>=0 ){
            fromAccount.setBalance(fromAccount.getBalance()-amount);
            toAccount.setBalance(toAccount.getBalance()+amount);
        }else {
            throw new NoSufficientFoundsException("not enough found");
        }
        repository.save(fromAccount);
        repository.save(toAccount);
    }

    private void validateAmount(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
    }

}
