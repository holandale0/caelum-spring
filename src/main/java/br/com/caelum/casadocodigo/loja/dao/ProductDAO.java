package br.com.caelum.casadocodigo.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.caelum.casadocodigo.loja.model.Product;

@Repository
public class ProductDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void save(Product produto){
		
		em.persist(produto);
		
	}
	
	//@NamedNativeQuery(name="Product.findAll", query="Select * form Product", resultClass=Product.class)
	public List<Product> listarTodos(){
			
		return em.createQuery("select distinct(p) from Product p join fetch p.prices order by p.id desc", Product.class).getResultList();
	}
	
	public List<Product> list(){
		
		return em.createQuery("select p from Product p join fetch p.prices", Product.class).getResultList();
		
	}
	
	public Product findById(Integer id){
		return em.createQuery("Select distinct p from Product p join fetch p.prices where p.id=:id", Product.class).setParameter("id", id).getSingleResult();
	}

}
