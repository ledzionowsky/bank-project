package org.example.service;

import org.example.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.mock;

public class ClientServiceTest {
    private ClientService service;
    private ClientRepository repository;

    @BeforeEach
    public void setup() {
        repository = mock(ClientRepository.class);
        ClientMapper mapper = mock(ClientMapper.class);
        service = new ClientService(repository, mapper);



  }
//    @Test
//    public void transfer_allParamsOk_foundsTransferred(){
//        //given
//        String emailFrom = "a@a.pl";
//        String emailTo = "m@m.pl";
//        Client clientFrom = new Client("Alek", emailFrom, Collections.singletonList(new Account(1000,"PLN")));
//        Client clientTo = new Client("Maciek", emailTo, Collections.singletonList(new Account(500,"PLN")));
//        final double amount=100;
//        when(repository.findByEmail(emailFrom)).thenReturn(clientFrom);
//        when(repository.findByEmail(emailTo)).thenReturn(clientTo);
//
//        //when
//        service.transfer(emailFrom,emailTo,amount);
//
//        //then
//
//        final Client expectedClientFrom = new Client("Alek", emailFrom, Collections.singletonList(new Account(900,"PLN")));
//        final Client expectedClientTo = new Client("Maciek", emailTo, Collections.singletonList(new Account(600,"PLN")));
//
//
//        verify(repository).save(expectedClientFrom);
//        verify(repository).save(expectedClientTo);
//
//    }
//
//    @Test
//    public void transfer_allFounds_foundsTransferred(){
//        //given
//        String emailFrom = "a@a.pl";
//        String emailTo = "m@m.pl";
//        Client clientFrom = new Client("Alek", emailFrom, Collections.singletonList(new Account(1000,"PLN")));
//        Client clientTo = new Client("Maciek", emailTo, Collections.singletonList(new Account(500,"PLN")));
//        when(repository.findByEmail(emailFrom)).thenReturn(clientFrom);
//        when(repository.findByEmail(emailTo)).thenReturn(clientTo);
//        final double amount=1000;
//
//        //when
//        service.transfer(emailFrom,emailTo,amount);
//
//        //then
//        final Client expectedClientFrom = new Client("Alek", emailFrom, Collections.singletonList(new Account(0,"PLN")));
//        final Client expectedClientTo = new Client("Maciek", emailTo, Collections.singletonList(new Account(1500,"PLN")));
//        verify(repository).save(expectedClientFrom);
//        verify(repository).save(expectedClientTo);
//
//    }
//
//    @Test
//    public void transfer_notEnoughFounds_throwsNotSufficientFoundException() {
//
//        //given
//        String emailFrom = "a@a.pl";
//        String emailTo = "m@m.pl";
//        Client clientFrom = new Client("Alek", emailFrom, Collections.singletonList(new Account(100,"PLN")));
//        Client clientTo = new Client("Maciek", emailTo, Collections.singletonList(new Account(500,"PLN")));
//        final double amount=1000;
//        when(repository.findByEmail(emailFrom)).thenReturn(clientFrom);
//        when(repository.findByEmail(emailTo)).thenReturn(clientTo);
//
//        //when/then
//        Assertions.assertThrows(
//                NoSufficientFoundsException.class,
//                () -> service.transfer(emailFrom,emailTo,amount)
//        );
//
//    }
//
//    @Test
//    public void transfer_negativeAmount_throwsIllegalArgumentException() {
//
//        //given
//        String emailFrom = "a@a.pl";
//        String emailTo = "m@m.pl";
//         final double amount=-1000;
//
//        //when/then
//        Assertions.assertThrows(
//                IllegalArgumentException.class,
//                () -> service.transfer(emailFrom,emailTo,amount)
//        );
//
//    }
//
//    @Test
//    public void transfer_toSameClient_throwException() {
//        //given
//        String email = "a@a.pl";
//        //when/then
//        Assertions.assertThrows(
//                IllegalArgumentException.class,
//                ()->service.transfer(email,email,10)
//        );
//    }
//
//    @Test
//    public void withdraw_correctAmount_balanceChangedCorrectly(){
//        //given
//        String email = "a@a.pl";
//        Client client = new Client("Alek", email, Collections.singletonList(new Account(100,"PLN")));
//
//        //when
//        when(repository.findByEmail(email)).thenReturn(client);
//        service.withdraw(email,50);
//        //then
//
//        Client expectedClient=new Client("Alek",email,Collections.singletonList(new Account(50,"PLN")));
//        verify(repository).save(expectedClient);
//
//    }
//
//    @Test
//    public void withdraw_allBalance_balanceSetToZero(){
//        //given
//        String email = "a@a.pl";
//        Client client = new Client("Alek", email, 100);
//        clients.add(client);
//        //when
//        service.withdraw(email,100);
//        //then
//
//        Client expectedClient=new Client("Alek",email,0);
//        Client actualClient = clients.get(0);
//        Assertions.assertEquals(expectedClient,actualClient);
//    }
//
//    @Test
//    public void withdraw_negativeAmount_throwsIllegalArgumentException(){
//        //given
//        String email = "a@a.pl";
//        Client client = new Client("Alek", email, 100);
//        clients.add(client);
//        int amount = -100;
//        //when
//        Assertions.assertThrows(
//                IllegalArgumentException.class,
//                ()->service.withdraw(email,amount));
//
//    }
//
//    @Test
//    public void withdraw_zeroAmount_throwsIllegalArgumentException(){
//        //given
//        String email = "a@a.pl";
//        Client client = new Client("Alek", email, 100);
//        clients.add(client);
//        int amount = 0;
//        //when
//        Assertions.assertThrows(
//                IllegalArgumentException.class,
//                ()->service.withdraw(email,amount));
//
//    }
//
//    @Test
//    public void withdraw_amountBiggerThanBalance_throwsNoSufficientFoundException(){
//        //given
//        String email = "a@a.pl";
//        Client client = new Client("Alek", email, 100);
//        clients.add(client);
//        int amount = 10000;
//        //when
//        Assertions.assertThrows(
//                NoSufficientFoundsException.class,
//                ()->service.withdraw(email,amount));
//    }
//
//    @Test
//    public void withdraw_incorrectEmail_throwsNoSuchElementException(){
//        //given
//        String email1 = "incorrect@a.pl";
//        int amount = 10000;
//        //when/then
//        Assertions.assertThrows(
//                NoSuchElementException.class,
//                ()->service.withdraw(email1,amount));
//    }
//
//
//    @Test
//    public void withdraw_upperCaseEmail_BalanceChangeCorrective(){
//        //given
//        String email = "A@A.pl";
//        Client client = new Client("Alek", "a@a.pl", 100);
//        clients.add(client);
//        //when
//        service.withdraw(email,50);
//        // //then
//        Client expectedClient=new Client("Alek","a@a.pl",50);
//        Client actualClient = clients.get(0);
//        Assertions.assertEquals(expectedClient,actualClient);    }
//
//    @Test
//    public void withdraw_nullEmail_throwsIllegalArgumentException(){
//        //given
//        String email1 = null;
//        int amount = 10000;
//        //when/then
//        Assertions.assertThrows(
//                IllegalArgumentException.class,
//                ()->service.withdraw(email1,amount));
//    }
//
//    @Test
//    public void withdraw_correctFloatingPointAmount_balanceChangeCorrective(){
//        String email = "a@a.pl";
//        Client client = new Client("Alek",email, 100);
//        clients.add(client);
//        //when
//        service.withdraw(email,50.5);
//        // //then
//        Client expectedClient=new Client("Alek","a@a.pl",49.5);
//        Client actualClient = clients.get(0);
//        Assertions.assertEquals(expectedClient,actualClient);
//    }
//
//
}
