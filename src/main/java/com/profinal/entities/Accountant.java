package com.profinal.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Accountant")
@DiscriminatorValue("ACCOUNTANT")
public class Accountant extends Person implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Accountant(String name, String lastname, String user, String password, String cell, String email) {
		this.name = name;
		this.lastname = lastname;
		this.password = password;
		this.cell = cell;
		this.email = email;
	}

	public Accountant() {
	}

}
