package br.com.caelum.casadocodigo.loja.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String titulo;
	
	private Integer paginas;
	
	@Lob
	private String descricao;

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

	@Override
	public String toString() {
		return "Livro [titulo=" + titulo + ", paginas=" + paginas + ", descricao=" + descricao + "]";
	}
	
	

}
