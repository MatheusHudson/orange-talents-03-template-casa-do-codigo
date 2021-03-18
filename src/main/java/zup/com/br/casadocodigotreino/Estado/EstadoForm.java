package zup.com.br.casadocodigotreino.Estado;


import javax.persistence.EntityManager;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import zup.com.br.casadocodigotreino.Pais.Pais;
import zup.com.br.casadocodigotreino.Validation.UniqueValue;


public class EstadoForm {

	@NotEmpty
	@UniqueValue(domainClass = Estado.class, fieldName = "nome")
	private String nome;
	
	@NotNull
	private Pais pais;
	
	

	public String getNome() {
		return nome;
	}



	public Pais getPais() {
		return pais;
	}



	public Estado toModel(EntityManager manager) {
		
		Pais pais = manager.find(Pais.class, this.pais.getId());
		if(pais == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi possivel encontra um pais com este id");
		}
		
		Estado estado = new Estado(nome, pais);
		pais.getEstados().add(estado);
		
		return estado;
	}
	

}


