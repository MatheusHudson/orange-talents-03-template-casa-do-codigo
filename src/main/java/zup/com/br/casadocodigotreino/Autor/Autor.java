package zup.com.br.casadocodigotreino.Autor;

import java.time.LocalDateTime;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;




@Entity
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty
	private String nome;
	
	@Email
	@NotEmpty
	@Column(unique = true)
	private String email;
	
	@NotEmpty
	@Length(min=0, max = 400)
	private String descricao;
	
	@NotNull
	private LocalDateTime instante = LocalDateTime.now();
	
	@Deprecated
	public Autor( ) {
		
	}
	
	public Autor(String nome) {
		
		this.nome = nome;
	}
	
	public Autor( String nome, String email, String descricao) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
		
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDateTime getInstante() {
		return instante;
	}
	
	
}
