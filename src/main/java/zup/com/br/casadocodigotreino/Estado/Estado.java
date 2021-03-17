package zup.com.br.casadocodigotreino.Estado;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import zup.com.br.casadocodigotreino.Pais.Pais;


@Entity
public class Estado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer id;
	

	@NotEmpty
	private String nome;
	
	@NotNull
	@ManyToOne
	private Pais pais;
	
	@Deprecated
	public Estado() {
		
	}


	public Pais getPais() {
		return pais;
	}


	public Integer getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}




	public Estado(@NotEmpty String nome, @NotEmpty Pais pais) {
		this.nome = nome;
		this.pais = pais;
	}



	
}
