package br.com.caelum.casadocodigo.loja.controller;

import java.math.BigDecimal;
import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.casadocodigo.loja.dao.ProductDAO;
import br.com.caelum.casadocodigo.loja.enums.BookType;
import br.com.caelum.casadocodigo.loja.model.PaymentData;
import br.com.caelum.casadocodigo.loja.model.Product;
import br.com.caelum.casadocodigo.loja.model.ShoppingCart;
import br.com.caelum.casadocodigo.loja.model.ShoppingItem;

@Controller
@RequestMapping("/shopping")
public class ShoppingCartController {
	
	@Autowired
	private ProductDAO dao;
	
	@Autowired
	private ShoppingCart shoppingCart;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView add(Integer productId, @RequestParam BookType bookType){
		Product product = dao.findById(productId);
		ShoppingItem item = new ShoppingItem(product, bookType);
		shoppingCart.add(createItem(productId, bookType));
		return new ModelAndView("redirect:/products");
	}
	
	
	private ShoppingItem createItem(Integer productId, BookType bookType){
		Product product = dao.findById(productId);
		ShoppingItem item = new ShoppingItem(product, bookType);
		return item;
	}
	
	@RequestMapping(value="/checkout" ,method=RequestMethod.POST)
	public Callable<String> checkout(){
		
		return()->{
		
		BigDecimal total = shoppingCart.getTotal();
		
		String uriToPay = "http://book-payment.herokuapp.com/payment";
		
		try{
			
			String response = restTemplate.postForObject(uriToPay, new PaymentData(total), String.class);
			
			System.out.println(response);
			
			return "redirect:/products";
					
		}catch(HttpClientErrorException exception){
			
			return "redirect:/shopping";
		}
		
		};
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String list(){
		return "shoppingCart/items";
	}

}
