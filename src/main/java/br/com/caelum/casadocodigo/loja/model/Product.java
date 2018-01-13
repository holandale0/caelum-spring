package br.com.caelum.casadocodigo.loja.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	private String titulo;

	@Min(30)
	@Max(5000)
	@NotNull
	private Integer paginas;
	
	@Lob
	@NotBlank
	private String descricao;
	

	@ElementCollection
	private List<Preco> precos = new ArrayList<Preco>();
	
	

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
		

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}
	
	

	public List<Preco> getPrecos() {
		return precos;
	}

	public void setPrecos(List<Preco> precos) {
		this.precos = precos;
	}

	public Integer getPaginas() {
		return paginas;
	}

	@Override
	public String toString() {
		return "Livro [titulo=" + titulo + ", paginas=" + paginas + ", descricao=" + descricao + "]";
	}
	
	

}
