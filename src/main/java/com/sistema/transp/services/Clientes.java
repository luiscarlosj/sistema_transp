package com.sistema.transp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sistema.transp.model.Cliente;

@Repository
public class Clientes {
	
	private static final List<Cliente> LISTA_CLIENTES = new ArrayList<>();

	static {
		LISTA_CLIENTES.add(new Cliente("Pedro", "Travessa IFMA", "8888-8888" ));
		LISTA_CLIENTES.add(new Cliente("Maria", "Rua UEMA", "2222-2222" ));
		LISTA_CLIENTES.add(new Cliente("Jose", "Alameda UFMA", "4444-4444" ));
	}

	public List<Cliente> todos() {
		return Clientes.LISTA_CLIENTES;
	}

	public void adicionar(Cliente cliente) {
		Clientes.LISTA_CLIENTES.add(cliente);
	}

}
