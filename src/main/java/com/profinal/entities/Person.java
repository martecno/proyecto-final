package com.profinal.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public abstract class Person implements Serializable {
	@Id
	private String name;
	private String user;
	private String password;
	private Integer cell;
	private String email;

	private void getUser() {
		// TODO Auto-generated method stub
	}

}
