package br.com.caelum.casadocodigo.loja.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.caelum.casadocodigo.loja.dao.ProductDAO;
import br.com.caelum.casadocodigo.loja.enums.TipoPreco;
import br.com.caelum.casadocodigo.loja.model.Product;
import br.com.caelum.casadocodigo.loja.validation.ProductValidator;

@Controller
@Transactional
@RequestMapping("products")
public class ProductsController {
	
	@Autowired
	private ProductDAO dao;
	
	//@InitBinder
	//public void initBinder(WebDataBinder binder){
		//binder.setValidator(new ProductValidator());
		//binder.addValidators(new ProductValidator());
		
	//}
	
	@RequestMapping("form")
	public ModelAndView form(Product product){ // O nome da variável product deve ter o mesmo nome da classe Product, apenas com a inicial minuscula
		ModelAndView mav = new ModelAndView("products/form");
		mav.addObject("tipos", TipoPreco.values());
		return mav;
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView salvar(@Valid Product product, BindingResult result, RedirectAttributes attr){
		
		if(result.hasErrors()){
			return form(product);
		}
		
		ModelAndView mav = new ModelAndView("redirect:products");
		attr.addFlashAttribute("sucesso", "Produto cadastrado com sucesso !");		
		dao.save(product);
		return mav;
	}
	
	 
	@RequestMapping(method=RequestMethod.GET) // A PARTIR DA VERSÃO 4.2 DO PRING, NÃO PRECISA ESPECIFICAR 
	public ModelAndView listarTodos(){		
		ModelAndView mav = new ModelAndView("products/lista");
		mav.addObject("produtos", dao.listarTodos());
		return mav;
		
	}

}
