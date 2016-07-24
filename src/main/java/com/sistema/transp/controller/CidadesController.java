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
import com.sistema.transp.repository.Cidader;

@Controller
public class CidadesController {
	
	@Autowired
	private Cidader cidader;
	
	@RequestMapping("/cidades")
	public ModelAndView listar() {
		
		List<Cidade> todasCidades = cidader.findAll();
		
		ModelAndView mv = new ModelAndView("ListaCidades");
		
		//mv.addObject("cidades", cidadess.todos());
		mv.addObject("cidades", todasCidades);
		
		mv.addObject(new Cidade());
		
		return mv;
	}
	
	@RequestMapping(value = "/cidades", method = RequestMethod.POST)
	public String salvar(@Validated Cidade cidade, Errors errors) {
		
		if ( errors.hasErrors() ) {
			return "redirect:/cidades";
		}
		
		this.cidader.save(cidade);
		
		return "redirect:/cidades";
	}
	
	@RequestMapping("/excluicidade/{id}")
	public String excluir(@PathVariable Long id) {
		
		this.cidader.delete(id);
		
		return "redirect:/cidades";
	}
	
	@RequestMapping("/editacidade/{cidade}")
	public ModelAndView editar(@PathVariable Cidade cidade) {
		
		ModelAndView mv = new ModelAndView("EditaCidade");
		
		mv.addObject(cidade);
		
		return mv;
	}
	
	@RequestMapping("/alteracidade")
	public String editaralterar(@Validated Cidade cidade) {
		
		Cidade cidadenova = cidade;

		this.cidader.delete(cidade.getId());

		this.cidader.save(cidadenova);

		return "redirect:/cidades";
	}
	
	

}














