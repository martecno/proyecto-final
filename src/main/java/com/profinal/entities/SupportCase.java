package com.profinal.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class SupportCase implements Serializable {
	@Id
	private String id;

	private void getClient() {
		// TODO Auto-generated method stub

	}

	public SupportCase() {
		// TODO Auto-generated constructor stub
	}

	private void getCalendar() {
		// TODO Auto-generated method stub

	}
}
