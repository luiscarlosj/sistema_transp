package com.sistema.transp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sistema.transp.model.Cidade;
import com.sistema.transp.repository.Cidader;

@Repository
public class Cidades {
	
	@Autowired
	private Cidader cidader;
	
	public double devolveValorEntrega(String cidade)
	{
		List<Cidade> todasCidades = cidader.findAll();
		
		for(int i = 0 ; i < todasCidades.size(); i++){
			
            if(cidade.equals(todasCidades.get(i).getNome()))
            {
            	return todasCidades.get(i).getValorEntrega();
            }
        }
		return 0;
	}
	
	
	/*private static final List<Cidade> LISTA_CLIENTES = new ArrayList<>();

	static {
		LISTA_CLIENTES.add(new Cidade("Sao Luis", "MA", new BigDecimal("10.00")));
		LISTA_CLIENTES.add(new Cidade("Fortaleza", "CE", new BigDecimal("10.50")));
		LISTA_CLIENTES.add(new Cidade("Belem", "PA",new BigDecimal("10.20")));
	}

	public List<Cidade> todos() {
		return Cidadess.LISTA_CLIENTES;
	}

	public void adicionar(Cidade cidade) {
		Cidadess.LISTA_CLIENTES.add(cidade);
	}*/

}
