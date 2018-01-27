package br.com.caelum.casadocodigo.loja.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.AntPathRequestMatcher;

@EnableWebMvcSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService users;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.antMatchers("/products/form").hasRole("ADMIN") // Só adm tem acesso ao form de cadastro
		.antMatchers(HttpMethod.POST, "/products").hasRole("ADMIN")
		.antMatchers("/products").permitAll()
		.antMatchers("/shopping/**").permitAll()
		.anyRequest().authenticated()
		.and().formLogin().loginPage("/login") // Chama a página de login criada no diretório auth
		.defaultSuccessUrl("/products") // autenticação bem sucedida redireciona para products
		.permitAll()
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout")) //
		.logoutSuccessUrl("/login") // logout bem sucedido redireciona para tela de login
		.permitAll()
		.and()
		.exceptionHandling()
		.accessDeniedPage("/WEB-INF/views/errors/403.jsp"); 
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.userDetailsService(users)
		.passwordEncoder(new BCryptPasswordEncoder());
		
	}

}
