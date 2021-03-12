package com.profinal.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Estimates implements Serializable {

	@Id
	private ArrayList<Material> materials = new ArrayList<>();
	private Date date;

}
