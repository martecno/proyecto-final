package com.profinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.profinal.entities.Person;
import com.profinal.entities.User;

@SpringBootApplication
public class MartecnoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MartecnoApplication.class, args);

		Person pepe = new User();

		pepe.setName("Pepe");
		pepe.setLastname("Rodriguez");
		System.out.println(pepe);
	}

}
