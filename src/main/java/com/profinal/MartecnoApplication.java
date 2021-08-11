package com.profinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.profinal.entities.Admin;
import com.profinal.entities.User;

@SpringBootApplication
public class MartecnoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MartecnoApplication.class, args);

		User pepe = new User();

		pepe.setName("Pepe");
		pepe.setLastname("Rodriguez");

		Admin admin = new Admin();

	}

}
