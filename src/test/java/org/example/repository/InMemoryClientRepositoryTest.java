//package org.example.repository;
//
//import org.example.repository.entity.Client;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class InMemoryClientRepositoryTest {
//
//    private InMemoryClientRepository repository;
//    private List<Client> clients;
//
//
//    @BeforeEach
//    public void setup(){
//        clients = new ArrayList<>();
//        repository=new InMemoryClientRepository(clients);
//    }
//
//    @Test
//    public void verifyIfUserIsAddingCorrectlyToTheRepository(){
//        //given
//        Client client = new Client("Alek", "a@a.pl", 100);
//        Client expectedClient = new Client("Alek", "a@a.pl", 100);
//
//        //when
//        repository.save(client);
//
//        //then
//        Client actualClient = clients
//                .stream()
//                .findFirst()
//                .get();
//
//
//
//    }
//
//
//}
