package br.com.caelum.casadocodigo.loja.validation;

import java.util.Objects;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.caelum.casadocodigo.loja.model.Product;

public class ProductValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Product.class.isAssignableFrom(clazz); // Verifica se a classe que chegou corresponde a Product
		
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "field.required");
		
		Product produto = (Product) target;
		
		if(Objects.isNull(produto.getNumberOfPages()) || produto.getNumberOfPages() <= 0){
			errors.rejectValue("numberOfPages", "filed.required");
		}
	}

}
