package com.profinal.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity

public class Client implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String direction;
	private Integer cuit;

	@OneToMany(mappedBy = "client")
	private List<SupportCase> supportCases;
	@OneToOne
	private Calendar calendar;

}
