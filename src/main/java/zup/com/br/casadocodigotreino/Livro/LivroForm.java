package zup.com.br.casadocodigotreino.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.executable.ValidateOnExecution;

import org.hibernate.annotations.NotFound;
import org.hibernate.engine.query.ParameterRecognitionException;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

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
	
	@NotEmpty
	@UniqueValue(domainClass = Livro.class, fieldName = "isbn")
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
	
	
	public LivroForm() {
		
	}
	
	
	
	public LivroForm(Livro livro) {
		
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.isbn = livro.getIsbn();
		this.dataLancamento = livro.getDataLancamento();
		this.sumario = livro.getSumario();
		this.numeroDePaginas = livro.getNumeroDePaginas();
		this.precoLivro = livro.getPrecoLivro();
		this.categoria = livro.getCategoria();
		this.autor = livro.getAutor();

	}



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

	
	
	@ValidateOnExecution
	public Livro converter(EntityManager manager) {
		
		 @NotNull Autor autor = manager.find(Autor.class, this.autor.getId());
		 Assert.state(autor!=null, "Este autor não existe no banco de dados!");
	     setAutor(autor);
	
		 Categoria categoria = manager.find(Categoria.class, this.categoria.getId());
		 Assert.state(categoria!=null, "Este autor não existe no banco de dados!");
		 setCategoria(categoria);
		
		return new Livro(isbn, titulo, resumo, sumario, precoLivro, numeroDePaginas, dataLancamento, this.categoria , this.autor);
	}
	
	
}
