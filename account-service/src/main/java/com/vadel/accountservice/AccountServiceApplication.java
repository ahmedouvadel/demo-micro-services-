package com.vadel.accountservice;

import com.vadel.accountservice.Entity.BankAccount;
import com.vadel.accountservice.Enum.AccountType;
import com.vadel.accountservice.Repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AccountRepository accountRepository){
		return args -> {
			List<BankAccount> accountList = List.of(
					BankAccount.builder()
							.accountId(UUID.randomUUID().toString())
							.accountType(AccountType.CURRENT_ACCOUNT)
							.balance(80000)
							.createAt(LocalDate.now())
							.customerId(Long.valueOf(1))
							.build(),
					BankAccount.builder()
							.accountId(UUID.randomUUID().toString())
							.accountType(AccountType.SAVING_ACCOUNT)
							.balance(60000)
							.createAt(LocalDate.now())
							.customerId(Long.valueOf(2))
							.build()
			);
			accountRepository.saveAll(accountList);
		};
	}

}
