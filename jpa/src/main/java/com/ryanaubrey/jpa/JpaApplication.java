package com.ryanaubrey.jpa;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaApplication {

	private static final Logger log = LoggerFactory.getLogger(JpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repo) {
		return (args) -> {
			repo.save(new Customer("Ryan", "Aubrey"));
			repo.save(new Customer("John", "Smith"));
			repo.save(new Customer("Jane", "Doe"));

			log.info("Created 3 customers... now let's find them!");
			log.info("-------------------------------------------");

			repo.findAll().forEach(customer -> {
				log.info(String.format("Customer found: %s - %s", customer.getFirstName(), customer.getId()));

				Optional<Customer> foundCustomer = repo.findById(customer.getId());

				if (foundCustomer.isPresent()) {
					log.info(String.format("Found %s with repo", foundCustomer.get().getFirstName()));
				}
			});

			log.info("-------------------------------------------");
			log.info("-------------------------------------------");

			String idRyan = repo.findByLastName("Aubrey").get(0).getId().toString();
			log.info(String.format("Ryan's id was - %s", idRyan));
		};
	}

}
