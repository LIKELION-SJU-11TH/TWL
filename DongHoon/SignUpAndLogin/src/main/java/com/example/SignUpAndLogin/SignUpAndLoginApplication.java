package com.example.SignUpAndLogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SignUpAndLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(SignUpAndLoginApplication.class, args);
	}

}
