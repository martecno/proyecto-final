package com.profinal.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity

public class Estimates implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToMany
	private List<Material> materials = new ArrayList<>();

	public BigDecimal getTotal() {
		return materials.stream().map(material -> material.getTotal()).reduce(BigDecimal.ZERO, BigDecimal::add);
	}

}
