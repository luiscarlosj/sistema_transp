package com.sistema.transp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;

@Entity
public class Cliente {
	
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long id;
	 
	 @NotNull
	 private String nome;
	 
	 @NotNull
	 private String endereco;
	 
	 @NotNull
	 @NumberFormat(pattern="####-####")
	 private String telefone;
	 
	 public Cliente() {

	 }

	 public Cliente(String nome, String endereco, String telefone) {
		 this.nome = nome;
		 this.endereco = endereco;
		 this.telefone = telefone;
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

	 public String getEndereco() {
		 return endereco;
	 }

	 public String getTelefone() {
		 return telefone;
	 }

	 public void setNome(String nome) {
		 this.nome = nome;
	 }

	 public void setEndereco(String endereco) {
		 this.endereco = endereco;
	 }

	 public void setTelefone(String telefone) {
		 this.telefone = telefone;
	 }

}
