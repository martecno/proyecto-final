package com.profinal.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity

public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	protected String name;
	protected String lastname;
	protected String password;
	protected Integer cell;
	protected String email;

	public Person(String name, String lastname, String password, Integer cell, String email) {
		this.name = name;
		this.lastname = lastname;
		this.password = password;
		this.cell = cell;
		this.email = email;

	}

}
