package com.karnikamit.school_admission_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.karnikamit.school_admission_system")
public class SchoolAdmissionSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolAdmissionSystemApplication.class, args);
	}

}

