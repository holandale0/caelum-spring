package br.com.caelum.casadocodigo.loja.conf;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableTransactionManagement
public class JpaConfigurationTest {
	
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
		
		JpaTransactionManager tm = new JpaTransactionManager();
		tm.setEntityManagerFactory(emf);
		
		return tm;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource){
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource);
		em.setPackagesToScan(new String[]{"br.com.caelum.casadocodigo.loja.model"});
		
		JpaVendorAdapter vendorAdaptor = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdaptor);
		em.setJpaProperties(aditionalProperties());
		
		return em;
	}
	
	
	@Bean
	@Profile("test")
	public DataSource dataSource(){
		
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/casadocodigo_test");
		ds.setUsername("root");
		ds.setPassword("caelum");
		
		return ds;
	}
	
	private Properties aditionalProperties(){
		
		Properties pp = new Properties();
		pp.setProperty("hibernate.hbm2ddl.auto", "update");
		pp.setProperty("hibernate.show_sql", "true");
		pp.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");//
		return pp;
		
	}
	

}
