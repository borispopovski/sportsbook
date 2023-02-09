package com.singular.sportsbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SportsbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportsbookApplication.class, args);
	}

}
