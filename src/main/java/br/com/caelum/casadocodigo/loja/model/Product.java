package br.com.caelum.casadocodigo.loja.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
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
import org.springframework.format.annotation.DateTimeFormat;

import br.com.caelum.casadocodigo.loja.enums.BookType;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	private String title;

	@Min(30)
	@Max(5000)
	@NotNull
	private Integer numberOfPages;
	
	@Lob
	@NotBlank
	private String description;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar releaseDate;
	
	private String summaryPath;
	
	@ElementCollection
	private List<Price> prices = new ArrayList<Price>();


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Integer getNumberOfPages() {
		return numberOfPages;
	}


	public void setNumberOfPages(Integer numberOfPages) {
		this.numberOfPages = numberOfPages;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public List<Price> getPrices() {
		return prices;
	}


	public void setPrices(List<Price> prices) {
		this.prices = prices;
	}
	
	


	public Calendar getReleaseDate() {
		return releaseDate;
	}


	public void setReleaseDate(Calendar releaseDate) {
		this.releaseDate = releaseDate;
	}
	

	public String getSummaryPath() {
		return summaryPath;
	}


	public void setSummaryPath(String summaryPath) {
		this.summaryPath = summaryPath;
	}


	@Override
	public String toString() {
		return "Product [title=" + title + ", numberOfPages=" + numberOfPages + ", description=" + description + "]";
	}
	
	public BigDecimal priceFor(BookType bookType){
		return prices.stream().filter(price -> price.getBookType().equals(bookType)).findFirst().get().getValue();
	}

	
	
	

}
