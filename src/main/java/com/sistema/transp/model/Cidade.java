package com.sistema.transp.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;

@Entity
public class Cidade {
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String estado;	
	
	@NotNull
	@NumberFormat(pattern="#,##0.00")
	public double valorEntrega;
	
	public Cidade() {
		
	}
	
	public Cidade(String nome, String estado, double valorEntrega) {
		this.nome = nome;
		this.estado = estado;
		this.valorEntrega = valorEntrega;
	}

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public double getValorEntrega() {
		return valorEntrega;
	}

	public void setValorEntrega(double valorEntrega) {
		this.valorEntrega = valorEntrega;
	}
	
	
	
	
}
