package com.vadel.customerservice;

import com.vadel.customerservice.Entity.Customer;
import com.vadel.customerservice.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return args -> {
			List<Customer> customerList = List.of(
					Customer.builder()
							.id(1L)
							.firstName("Ahmedou")
							.lastName("vadel")
							.email("ahmedvadel94@gmail.com")
							.build(),
					Customer.builder()
							.id(2L)
							.firstName("Dady")
							.lastName("Sayid")
							.email("dadysaid@gmail.com")
							.build()
			);
			customerRepository.saveAll(customerList);
		};
	}

}
