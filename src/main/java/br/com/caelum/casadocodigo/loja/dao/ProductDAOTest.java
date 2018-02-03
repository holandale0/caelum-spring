package br.com.caelum.casadocodigo.loja.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.caelum.casadocodigo.loja.builders.ProductBuilder;
import br.com.caelum.casadocodigo.loja.conf.JpaConfigurationTest;
import br.com.caelum.casadocodigo.loja.enums.BookType;
import br.com.caelum.casadocodigo.loja.model.Product;
import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaConfigurationTest.class, ProductDAO.class})
@ActiveProfiles("test")
public class ProductDAOTest {
	
	@Autowired
	private ProductDAO dao;
	

	
	@Transactional
	@Test
	public void shouldSumAllPricesOfEachPerType(){
		List<Product> printedBooks = ProductBuilder.newProduct(BookType.IMPRESSO, BigDecimal.TEN).more(4).buildAll();
		printedBooks.stream().forEach(dao::save);
		
		List<Product> ebooks = ProductBuilder.newProduct(BookType.EBOOK, BigDecimal.TEN).more(4).buildAll();
		printedBooks.stream().forEach(dao::save);
		
		BigDecimal value = dao.sumPricesPerType(BookType.IMPRESSO);
		
		Assert.assertEquals(new BigDecimal(50).setScale(2),value);
	}
	
	
	
	
	
	
	@Test
	public void testVerificaQuantidadeDeLivros(){
		Product product = new Product();
		dao.save(product);
		
		assert dao.somaLivros() == 1;
	}

}
