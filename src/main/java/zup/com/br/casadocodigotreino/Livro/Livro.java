package zup.com.br.casadocodigotreino.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

import zup.com.br.casadocodigotreino.Autor.Autor;
import zup.com.br.casadocodigotreino.Categoria.Categoria;

@Entity
public class Livro {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		
		@NotEmpty
		@Column(unique = true)
		private String titulo;
		
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
		
		@NotNull
		private String isbn;
		
		@Deprecated
		public Livro() {
			
		}
		
		public Livro(@NotNull String isbn, @NotEmpty String titulo, @NotEmpty @Length(max = 500) String resumo, String sumario,
				@Min(20) BigDecimal precoLivro, @NotNull @Min(100) Integer numeroDePaginas,
				@Future LocalDate dataLancamento, @NotNull Categoria categoria, @NotNull Autor autor) {
			
			this.isbn = isbn;
			this.titulo = titulo;
			this.resumo = resumo;
			this.sumario = sumario;
			this.precoLivro = precoLivro;
			this.numeroDePaginas = numeroDePaginas;
			this.dataLancamento = dataLancamento;
			this.categoria = categoria;
			this.autor = autor;
		}

		public @NotNull String getIsbn() {
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

		public Integer getId() {
			return id;
		}
		
		
}
