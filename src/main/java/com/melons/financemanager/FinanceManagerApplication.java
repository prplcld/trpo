package com.melons.financemanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@EntityScan("com.melons.financemanager")
@EnableJpaRepositories(basePackages = "com.melons.financemanager")
@SpringBootApplication
public class FinanceManagerApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(FinanceManagerApplication.class, args);
	}

	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

