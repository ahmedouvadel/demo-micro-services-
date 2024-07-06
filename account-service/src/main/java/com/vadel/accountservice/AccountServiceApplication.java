package com.vadel.accountservice;

import com.vadel.accountservice.Entity.BankAccount;
import com.vadel.accountservice.Enum.AccountType;
import com.vadel.accountservice.Repository.AccountRepository;
import com.vadel.accountservice.clients.CustomerRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AccountRepository accountRepository, CustomerRestClient customerRestClient){
		return args -> {
			customerRestClient.getAllCustomers().forEach(customer -> {
			BankAccount bankAccount1 = 	BankAccount.builder()
						.accountId(UUID.randomUUID().toString())
						.accountType(AccountType.CURRENT_ACCOUNT)
						.balance(80000)
						.createAt(LocalDate.now())
						.customerId(customer.getId())
						.build();
			BankAccount bankAccount2 = BankAccount.builder()
								.accountId(UUID.randomUUID().toString())
								.accountType(AccountType.SAVING_ACCOUNT)
								.balance(60000)
								.createAt(LocalDate.now())
								.customerId(customer.getId())

								.build();

				accountRepository.save(bankAccount1);
				accountRepository.save(bankAccount2);
			});

		};
	}

}
