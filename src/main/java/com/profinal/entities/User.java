package com.profinal.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "user")
@DiscriminatorValue("USER")

public class User extends Person {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public User(String name, String lastname, String user, String password, String cell, String email) {
		this.name = name;
		this.lastname = lastname;
		this.password = password;
		this.cell = cell;
		this.email = email;
	}

	public User() {
	}

}