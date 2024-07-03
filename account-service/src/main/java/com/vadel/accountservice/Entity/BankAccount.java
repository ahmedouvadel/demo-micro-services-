package com.vadel.accountservice.Entity;

import com.vadel.accountservice.Enum.AccountType;
import com.vadel.accountservice.module.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccount {
    @Id
    private String accountId;
    private double balance;
    private LocalDate createAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @Transient
    private Customer customer;
    private Long customerId;
}
