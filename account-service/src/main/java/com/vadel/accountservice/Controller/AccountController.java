package com.vadel.accountservice.Controller;

import com.vadel.accountservice.Entity.BankAccount;
import com.vadel.accountservice.Repository.AccountRepository;
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

    @GetMapping(path = "/accounts")
    public List<BankAccount> getAllAccounts(){
        return accountRepository.findAll();
    }

    @GetMapping(path = "/account/{accountId}")
    public BankAccount getAccount(@PathVariable String accountId){
        return accountRepository.findById(accountId).orElse(null);
    }


}
