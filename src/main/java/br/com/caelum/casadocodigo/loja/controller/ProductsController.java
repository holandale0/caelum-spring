package br.com.caelum.casadocodigo.loja.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.caelum.casadocodigo.loja.dao.ProductDAO;
import br.com.caelum.casadocodigo.loja.enums.BookType;
import br.com.caelum.casadocodigo.loja.infra.FileSaver;
import br.com.caelum.casadocodigo.loja.model.Product;
import br.com.caelum.casadocodigo.loja.validation.ProductValidator;

@Controller
@Transactional
@RequestMapping("products")
public class ProductsController {
	
	@Autowired
	private ProductDAO dao;
	
	@Autowired
	private FileSaver fileSaver;
	
	//@InitBinder
	//public void initBinder(WebDataBinder binder){
		//binder.setValidator(new ProductValidator());
		//binder.addValidators(new ProductValidator());
		
	//}
	
	@RequestMapping("form")
	public ModelAndView form(Product product){ // O nome da variável product deve ter o mesmo nome da classe Product, apenas com a inicial minuscula
		ModelAndView mav = new ModelAndView("products/form");
		mav.addObject("prices", BookType.values());
		return mav;
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	@CacheEvict(value="lastProducts", allEntries=true)
	public ModelAndView salvar(MultipartFile summary, @Valid Product product, BindingResult result, RedirectAttributes attr){
		
		if(result.hasErrors()){
			return form(product);
		}
		
		String webPath = fileSaver.write("uploaded-summaries", summary);
		product.setSummaryPath(webPath);
		
		ModelAndView mav = new ModelAndView("redirect:products");
		attr.addFlashAttribute("sucess", "Produto "+ product+"\ncadastrado com sucesso !");		
		dao.save(product);
		return mav;
	}
	
	 
	@RequestMapping(method=RequestMethod.GET) // A PARTIR DA VERSÃO 4.2 DO PRING, NÃO PRECISA ESPECIFICAR 
	@Cacheable(value="lastProducts")
	public ModelAndView listarTodos(){		
		ModelAndView mav = new ModelAndView("products/list");
		List<Product> produtos = dao.listarTodos();
		mav.addObject("products", produtos);
		return mav;
		
	}
	
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public ModelAndView show(@PathVariable("id") Integer id){
		
		ModelAndView mav = new ModelAndView("products/show");
		Product product = dao.findById(id);
		mav.addObject("product", product);
		
		return mav;
		
	}

}
