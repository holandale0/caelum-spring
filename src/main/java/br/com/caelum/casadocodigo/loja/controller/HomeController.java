package br.com.caelum.casadocodigo.loja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("home")
	public String index(){
		System.out.println("carregando os produtos");
		return "hello-word";
	}

}
