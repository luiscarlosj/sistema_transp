package com.sistema.transp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;

@Entity
public class Frete {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private int codigo;
	
	@NotNull
	private String descricao;
	
	@NotNull
	@NumberFormat(pattern="#,##0.00")
	private double pesoTotal;
	
	@NotNull
	private String cliente;
	
	@NotNull
	private String cidade;
	
	@NotNull
	@NumberFormat(pattern="#,##0.00")
	private double valorFrete;
	
	private double valorFixo = 4;
	
	public Frete() {
		
	}
	
	public Frete(int codigo, String descricao, double pesoTotal, String cliente, String cidade, double valorFrete) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.pesoTotal = pesoTotal;
		this.cliente = cliente;
		this.cidade = cidade;
		this.valorFrete = valorFrete;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public double getPesoTotal() {
		return pesoTotal;
	}
	
	public void setPesoTotal(double pesoTotal) {
		this.pesoTotal = pesoTotal;
	}
	
	public String getCliente() {
		return cliente;
	}
	
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public double getValorFrete() {
		return valorFrete;
	}	

	public void setValorFrete(double valorFrete) {
		this.valorFrete = valorFrete;
	}
	
	public double getValorFixo() {
		return valorFixo;
	}
	
	public void setValorFixo(double valorFixo) {
		this.valorFixo = valorFixo;
	}
	
	
	
}
