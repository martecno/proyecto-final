package com.profinal.entities;

import java.io.Serializable;

import javax.persistence.Id;

public class Supplier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private String name;
	private Long cuit;
	private String material;

	public Supplier() {

	}

}
