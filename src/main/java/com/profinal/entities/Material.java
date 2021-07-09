package com.profinal.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Material implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Stock stock;
	private BigDecimal quantity = BigDecimal.ZERO;
	private BigDecimal fullPrice = BigDecimal.ZERO;

	public BigDecimal getTotal() {
		if (fullPrice != null && quantity != null)
			return fullPrice.multiply(quantity);
		return BigDecimal.ZERO;

	}
}
