package com.employee.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EcommercewebApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommercewebApplication.class, args);
		
		System.out.println("run successfully ");
	}

}
