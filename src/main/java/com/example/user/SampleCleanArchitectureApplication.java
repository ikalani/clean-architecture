package com.example.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.example"})
public class SampleCleanArchitectureApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleCleanArchitectureApplication.class, args);
	}

}
