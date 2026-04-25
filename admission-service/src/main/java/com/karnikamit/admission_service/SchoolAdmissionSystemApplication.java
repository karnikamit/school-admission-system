package com.karnikamit.admission_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.karnikamit")
public class SchoolAdmissionSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolAdmissionSystemApplication.class, args);
	}

}

