package com.profinal.entities;

import java.io.Serializable;

import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class CheckingAccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private Integer deposit;
	private Integer withdraw;

	public CheckingAccount() {

	}

}
