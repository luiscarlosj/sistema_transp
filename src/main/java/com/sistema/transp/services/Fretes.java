package com.sistema.transp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sistema.transp.model.Frete;

@Repository
public class Fretes {
	
	@Autowired
	private Cidades cidades;
	
	public Frete calculaValorFrete(Frete frete) {
		
		frete.setValorFrete(frete.getPesoTotal() * frete.getValorFixo() * cidades.devolveValorEntrega(frete.getCidade()));
		
		return frete;		
		
	}
	
	
}
