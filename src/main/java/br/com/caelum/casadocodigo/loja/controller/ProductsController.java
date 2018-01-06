package br.com.caelum.casadocodigo.loja.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.caelum.casadocodigo.loja.dao.ProductDAO;
import br.com.caelum.casadocodigo.loja.model.Product;

@Controller
@Transactional
@RequestMapping("products")
public class ProductsController {
	
	@Autowired
	private ProductDAO dao;
	
	@RequestMapping("form")
	public String form(){
		
		return "products/form";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvar(Product produto){
		System.out.println("Cadastrando o produto"+produto);
		dao.save(produto);
		return "products/ok";
	}

}
