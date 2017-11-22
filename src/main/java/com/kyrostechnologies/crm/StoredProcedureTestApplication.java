package com.kyrostechnologies.crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages = "com.kyrostechnologies.crm")
@EnableJpaRepositories(basePackages = "com.kyrostechnologies.crm")
@EntityScan(basePackages = "com.kyrostechnologies.crm")
public class StoredProcedureTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoredProcedureTestApplication.class, args);
	}
}
