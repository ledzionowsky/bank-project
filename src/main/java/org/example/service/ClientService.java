package org.example.service;

import org.example.controller.dto.ClientRequest;
import org.example.controller.dto.ClientResponse;
import org.example.repository.ClientRepository;
import org.example.repository.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper mapper;


    @Autowired
    public ClientService(
            ClientRepository clientRepository,
            ClientMapper mapper) {
        this.clientRepository = clientRepository;
        this.mapper = mapper;
    }

    public void save(ClientRequest clientRequest){
        Client client = mapper.map(clientRequest);
        clientRepository.save(client);
    }

    public Client findByEmail(String email){

        return clientRepository.findByEmail(email);
    }


    public ClientResponse findResponseByEmail(String email){
        Client client = findByEmail(email);
        return mapper.map(client);
    }

//    public void transfer(String fromEmail, String toEmail, double amount){
//
//        validateAmount(amount);
//        if (fromEmail.equals(toEmail)){
//            throw new IllegalArgumentException("fromEmail and ToEmail cant be equal");
//        }
//
//        Client fromClient = findByEmail(fromEmail);
//        Client toClient = findByEmail(toEmail);
//
//
//        if (fromClient.getBalance() -amount>=0 ){
//            fromClient.setBalance(fromClient.getBalance()-amount);
//            toClient.setBalance(toClient.getBalance()+amount);
//        }else {
//            throw new NoSufficientFoundsException("not enough found");
//        }
//        clientRepository.save(fromClient);
//        clientRepository.save(toClient);
//
//
//
//    }
//
//    public void withdraw(String email, double amount) {
//        validateAmount(amount);
//        if (Objects.isNull(email)){
//            throw new IllegalArgumentException("Emial cant be null");
//        }
//        String lowerCaseEmail = email.toLowerCase();
//        Client client = clientRepository.findByEmail(lowerCaseEmail);
//
//        if (amount>client.getBalance()){
//            throw new NoSufficientFoundsException("Balance must be higher or equal than amount");
//        }
//        double newBalance = client.getBalance() - amount;
//        client.setBalance(newBalance);
//        clientRepository.save(client);
//    }
//
//    private void validateAmount(double amount) {
//        if (amount <= 0) {
//            throw new IllegalArgumentException("Amount must be positive");
//        }
//    }
}
