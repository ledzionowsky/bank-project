package org.example.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="USERS")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;
    @Column(name = "FIRST_NAME")
    private String name;
    @Column(name = "MAIL")
    private String email;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private List<Account>accounts;

    public Client(String name, String email, List<Account> accounts) {
        this.name = name;
        this.email = email;
        this.accounts = accounts;
    }

    public double getBalance() {
        if (!accounts.isEmpty()){
            return accounts.get(0).getBalance();
        }
        return 0;
    }

    public void setBalance(double newBalance) {
        if (!accounts.isEmpty()){
            accounts.get(0).setBalance(newBalance);
        }
    }
}
