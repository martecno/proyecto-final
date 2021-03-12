package com.profinal.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Stock implements Serializable {
	@Id
	private String name;
	private String reference;
	private Integer price;
}
