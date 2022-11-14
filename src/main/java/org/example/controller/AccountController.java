package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.controller.dto.AccountRequest;
import org.example.controller.dto.AccountResponse;
import org.example.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AccountController {
    private final AccountService service;

    @GetMapping(path = "/api/account")
    public ResponseEntity<AccountResponse> findById(@RequestParam long id){
        final AccountResponse account = service.find(id);
        return new ResponseEntity<>(account, HttpStatus.ACCEPTED);
    }

    @PostMapping(path = "/api/account")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createAccount(@RequestBody AccountRequest account){
        service.save(account);
    }
}
