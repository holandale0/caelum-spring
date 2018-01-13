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
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "titulo", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descricao", "field.required");
		
		Product produto = (Product) target;
		
		if(Objects.isNull(produto.getPaginas()) || produto.getPaginas() <= 0){
			errors.rejectValue("paginas", "filed.required");
		}
	}

}
