package com.vadel.accountservice.Controller;

import com.vadel.accountservice.Entity.BankAccount;
import com.vadel.accountservice.Repository.AccountRepository;
import com.vadel.accountservice.clients.CustomerRestClient;
import com.vadel.accountservice.module.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AccountController {

    private final AccountRepository accountRepository;
    private final CustomerRestClient customerRestClient;

    @GetMapping(path = "/accounts")
    public List<BankAccount> getAllAccounts(){
        return accountRepository.findAll();
    }

    @GetMapping(path = "/accounts/{accountId}")
    public BankAccount getAccount(@PathVariable String accountId){
        BankAccount bankAccount= accountRepository.findById(accountId).orElse(null);
        Customer customer =customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }


}
