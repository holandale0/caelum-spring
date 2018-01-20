package br.com.caelum.casadocodigo.loja.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.caelum.casadocodigo.loja.enums.BookType;

@Embeddable
public class Price {
	
	@Column(scale = 2)
	private BigDecimal value;
	
	@Enumerated(EnumType.STRING)
	private BookType bookType;

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public BookType getBookType() {
		return bookType;
	}

	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}
	
	


	
	
	

}
