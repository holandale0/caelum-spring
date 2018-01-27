package br.com.caelum.casadocodigo.loja.conf;


import javax.servlet.MultipartConfigElement;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;




public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class[]{SecurityConfiguration.class,AppWebConfiguration.class,JpaConfiguration.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class[]{}; //
	}

	@Override
	protected String[] getServletMappings() {
		
		return new String[]{"/"};
	}
	
	@Override
	protected void customizeRegistration(javax.servlet.ServletRegistration.Dynamic registration) {
		registration.setMultipartConfig(new MultipartConfigElement(""));
	}

}
