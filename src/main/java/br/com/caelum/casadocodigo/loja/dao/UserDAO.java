package br.com.caelum.casadocodigo.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.caelum.casadocodigo.loja.model.User;

@Repository
public class UserDAO implements UserDetailsService{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		String jpql = "select u from User u where login = :login";
		List<User> users = em.createQuery(jpql,User.class).setParameter("login",username).getResultList();
		
		if(users.isEmpty()){
			throw new UsernameNotFoundException("O usuário "+username+" não existe");
		}
		
		return users.get(0);
	}

}
