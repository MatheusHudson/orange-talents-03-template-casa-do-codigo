package zup.com.br.casadocodigotreino.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

import zup.com.br.casadocodigotreino.Autor.Autor;
import zup.com.br.casadocodigotreino.Autor.AutorRepository;
import zup.com.br.casadocodigotreino.Categoria.Categoria;
import zup.com.br.casadocodigotreino.Categoria.CategoriaRepository;
import zup.com.br.casadocodigotreino.Validation.UniqueValue;

public class LivroForm {

	@NotEmpty
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo")
	private String titulo;
	
	@NotNull
	private String isbn;
	
	@NotEmpty @Length(max= 500)
	private String resumo;
	
	private String sumario;
	
	@Min(20)
	private BigDecimal precoLivro;
	
	@NotNull @Min(100)
	private Integer numeroDePaginas;
	
	@Future
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataLancamento;
	
	@ManyToOne
	@NotNull
	private Categoria categoria;
	
	@ManyToOne
	@NotNull 
	private Autor autor;
	
	

	
	public String getIsbn() {
		return isbn;
	}


	public String getTitulo() {
		return titulo;
	}


	public String getResumo() {
		return resumo;
	}


	public String getSumario() {
		return sumario;
	}


	public BigDecimal getPrecoLivro() {
		return precoLivro;
	}


	public Integer getNumeroDePaginas() {
		return numeroDePaginas;
	}


	public LocalDate getDataLancamento() {
		return dataLancamento;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public Autor getAutor() {
		return autor;
	}

	

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public void setAutor(Autor autor) {
		this.autor = autor;
	}


	public Livro converter(AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
		
	
	    Optional<Autor> autor = autorRepository.findByNome(this.autor.getNome());
		
	    	if(!autor.isPresent()) {
	    		throw new IllegalArgumentException("Autor não pode ser nulo!");
	    	}
	    
	    	setAutor(autor.get());
		
		@NotNull Optional<Categoria> categoria = categoriaRepository.findByNome(this.categoria.getNome());
		
		if(!categoria.isPresent()) {
			throw new IllegalArgumentException("Categoria não pode ser nula!");
		}
	
		setCategoria(categoria.get());
		
		return new Livro(isbn, titulo, resumo, sumario, precoLivro, numeroDePaginas, dataLancamento, this.categoria , this.autor);
	}
}
