package com.profinal.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class CheckingAccount implements Serializable {
	@Id
	private Integer deposit;
	private Integer withdraw;

}
