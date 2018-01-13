package br.com.caelum.casadocodigo.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.annotations.NamedNativeQuery;
import org.springframework.stereotype.Repository;

import br.com.caelum.casadocodigo.loja.model.Product;

@Repository
public class ProductDAO {
	
	@PersistenceContext
	EntityManager em;
	
	public void save(Product produto){
		
		em.persist(produto);
		
	}
	
	//@NamedNativeQuery(name="Product.findAll", query="Select * form Product", resultClass=Product.class)
	public List<Product> listarTodos(){
			
		return em.createQuery("Select distinct p from Product p join fetch p.precos order by p.id desc", Product.class).getResultList();
	}

}
