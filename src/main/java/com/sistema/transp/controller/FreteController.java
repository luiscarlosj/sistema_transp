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

import com.sistema.transp.model.Cidade;
import com.sistema.transp.model.Cliente;
import com.sistema.transp.model.Frete;
import com.sistema.transp.repository.Cidader;
import com.sistema.transp.repository.Clienter;
import com.sistema.transp.repository.Freter;
import com.sistema.transp.services.Cidades;
import com.sistema.transp.services.Clientes;
import com.sistema.transp.services.Fretes;

@Controller
public class FreteController {
	
	@Autowired
	private Clienter clienter;
	
	@Autowired
	private Cidader cidader;
	
	@Autowired
	private Freter freter;
	
	@Autowired
	private Fretes freteservice;
	
	@RequestMapping("/fretes")
	public ModelAndView listar() {
		
		List<Cliente> todosClientes = (List<Cliente>) clienter.findAll();		
		List<Cidade> todasCidades = cidader.findAll();		
		List<Frete> todosFretes = freter.findAll();
		
		ModelAndView mv = new ModelAndView("ListaFretes");
		
		mv.addObject("clientes", todosClientes);		
		mv.addObject("cidades", todasCidades);		
		mv.addObject("fretes", todosFretes);
		
		mv.addObject(new Frete());		
		mv.addObject(new Cliente());		
		mv.addObject(new Cidade());
		
		return mv;
	}
	
	@RequestMapping(value = "/fretes", method = RequestMethod.POST)
	public String salvar(@Validated Frete frete, Errors errors) {
		
		if ( errors.hasErrors() ) {
			return "redirect:/fretes";
		}
		
		this.freter.save(frete);
		
		return "redirect:/fretes";
	}
	
	@RequestMapping("/excluifrete/{id}")
	public String excluir(@PathVariable Long id) {
		
		this.freter.delete(id);
		
		return "redirect:/fretes";
	}
	
	@RequestMapping("/editafrete/{frete}")
	public ModelAndView editar(@PathVariable Frete frete) {
		
		ModelAndView mv = new ModelAndView("EditaFrete");
		
		mv.addObject(frete);
		
		return mv;
	}
	
	@RequestMapping("/alterafrete")
	public String editaralterar(@Validated Frete frete) {
		
		Frete fretenovo = frete;

		this.freter.delete(frete.getId());

		this.freter.save(fretenovo);

		return "redirect:/fretes";
	}
	
	@RequestMapping(value = "/calculavalor", method = RequestMethod.POST)
	public ModelAndView calcularValor(Frete frete) {
		
		ModelAndView mv = new ModelAndView("CalculaValorFrete");  
        
        mv.addObject("frete",freteservice.calculaValorFrete(frete));
        
        return mv;
	}

}
