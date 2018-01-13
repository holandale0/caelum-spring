package br.com.caelum.casadocodigo.loja.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.caelum.casadocodigo.loja.enums.TipoPreco;

@Embeddable
public class Preco {
	
	@Column(scale = 2)
	private BigDecimal valor;
	
	@Enumerated(EnumType.STRING)
	private TipoPreco tipo;

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TipoPreco getTipo() {
		return tipo;
	}

	public void setTipo(TipoPreco tipo) {
		this.tipo = tipo;
	}
	
	
	

}
