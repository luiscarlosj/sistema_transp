package com.sistema.transp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sistema.transp.model.Cliente;
import com.sistema.transp.repository.Clienter;

@Controller
public class ClientesController {
	
	@Autowired
	private Clienter clientes;
	
	@RequestMapping("/clientes")
	public ModelAndView listar() {
		
		//List<Cliente> todosClientes = clientes.findAll();
		List<Cliente> todosClientes = (List<Cliente>) clientes.findAll();
		
		ModelAndView mv = new ModelAndView("ListaClientes");
		
		mv.addObject("clientes", todosClientes);
		
		mv.addObject(new Cliente());
		
		return mv;
	}
	
	@RequestMapping(value = "/clientes", method = RequestMethod.POST)
	public String salvar(@Validated Cliente cliente, Errors errors) {
		
		if ( errors.hasErrors() ) {
			return "redirect:/clientes";
		}
		
		this.clientes.save(cliente);
		
		return "redirect:/clientes";
	}
	
	@RequestMapping("/excluicliente/{id}")
	public String excluir(@PathVariable Long id) {
		
		this.clientes.delete(id);
		
		return "redirect:/clientes";
	}
	
	@RequestMapping("/editacliente/{cliente}")
	public ModelAndView editar(@PathVariable Cliente cliente) {
		
		ModelAndView mv = new ModelAndView("EditaCliente");
		
		mv.addObject(cliente);
		
		return mv;
	}
	
	@RequestMapping("/alteracliente")
	public String editaralterar(@Validated Cliente cliente) {
		
		Cliente clientenovo = cliente;

		this.clientes.delete(cliente.getId());

		this.clientes.save(clientenovo);

		return "redirect:/clientes";
	}

}
