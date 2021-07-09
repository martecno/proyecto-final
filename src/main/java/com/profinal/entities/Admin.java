package com.profinal.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "admin")
@DiscriminatorValue("ADMIN")

public class Admin extends User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Admin(String name, String lastname, String user, String password, Integer cell, String email) {
		this.name = name;
		this.lastname = lastname;
		this.password = password;
		this.cell = cell;
		this.email = email;
	}

	public Admin() {
		// TODO Auto-generated constructor stub
	}
}

//	public Admin(String name, String lastname, String user, String password, Integer cell, String email) {
//		super(name, lastname, user, password, cell, email);
//	}