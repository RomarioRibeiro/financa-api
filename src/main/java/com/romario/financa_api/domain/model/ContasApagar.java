package com.romario.financa_api.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ContasApagar {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String  descricao;
	private OffsetDateTime dataEmissao;
	private BigDecimal valor;
	private OffsetDateTime dataVencimento;
	private int parcelas;
	@ManyToOne
	private Pessoa pessoa;
	
}
