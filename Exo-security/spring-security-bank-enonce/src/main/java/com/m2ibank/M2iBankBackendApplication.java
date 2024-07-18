package com.m2ibank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@SpringBootApplication
public class M2iBankBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(M2iBankBackendApplication.class, args);
	}

}
