package com.sevenpeaks.design.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class SevenPeaksApiDrivenDesignApplication {

	public static void main(String[] args) {
		SpringApplication.run(SevenPeaksApiDrivenDesignApplication.class, args);
	}

	@Bean
	CommandLineRunner init(PizzaRepository repository) { // (1)
		return args -> { // (2)
			repository.save(new Pizza("pizza-1", "Pizza Napoli", 130));
			repository.save(new Pizza("pizza-2", "Pizza Quattro Formagi", 200));
			repository.save(new Pizza("pizza-3", "Pizza Diavola", 230));
		};
	}
}
