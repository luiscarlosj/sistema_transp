package com.sistema.transp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PrincipalController {
	
	@RequestMapping("/principal")
	public ModelAndView mostrar() {
		
		ModelAndView mv = new ModelAndView("Principal");
		
		return mv;
	}	

}
