package br.com.caelum.casadocodigo.loja.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.caelum.casadocodigo.loja.model.Product;

@Repository
public class ProductDAO {
	
	@PersistenceContext
	EntityManager em;
	
	public void save(Product produto){
		
		em.persist(produto);
		
	}

}
