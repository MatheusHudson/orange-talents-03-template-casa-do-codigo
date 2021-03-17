package zup.com.br.casadocodigotreino.Pais;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import zup.com.br.casadocodigotreino.Estado.Estado;


@Entity
public class Pais   {
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer id;
	
	@Column(unique = true)
	@NotEmpty
	private String nome;
	
	@Column(unique = true)
	@OneToMany
	private List<Estado> estados = new ArrayList<>();
 	

	@Deprecated
	public Pais() {
		
	}
	
	
	public List<Estado> getEstados() {
		return estados;
	}


	public Pais(Integer id) {
		this.id = id;
	}

	public Pais(@NotEmpty String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	
	

}
