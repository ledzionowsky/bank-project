package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.controller.dto.ClientRequest;
import org.example.controller.dto.ClientResponse;
import org.example.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ClientController {
    private final ClientService service;

    @GetMapping(path = "/api/user")
    public ResponseEntity<ClientResponse> findByEmail(@RequestParam String email){
        ClientResponse client = service.findResponseByEmail(email);
        return new ResponseEntity<>(client, HttpStatus.ACCEPTED);
    }

    @PostMapping(path = "/api/user")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createClient(@RequestBody ClientRequest client){
        service.save(client);
    }

}
