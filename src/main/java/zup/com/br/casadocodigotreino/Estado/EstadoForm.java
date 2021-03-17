package zup.com.br.casadocodigotreino.Estado;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import zup.com.br.casadocodigotreino.Pais.Pais;


public class EstadoForm {

	@NotEmpty
	private String nome;
	
	@NotNull
	private Pais pais;
	
	

	public String getNome() {
		return nome;
	}



	public Pais getPais() {
		return pais;
	}



	public Estado converter(EntityManager manager) {
		
		Pais pais = manager.find(Pais.class, this.pais.getId());
		
		if(pais == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi possivel encontra um pais com este id");
		}
		Estado estado = new Estado(nome, pais);
		validarEstado(manager, pais, estado);
		pais.getEstados().add(estado);
		
		return estado;
	}
	
	
	public void validarEstado(EntityManager manager, Pais pais, Estado estado) {
		
		Query query =  manager.createQuery("Select p From Pais p JOIN Estado e ON p.id = e.pais.id Where e.nome = :pEstadoNome AND p.id = :pPaisId "); 
		query.setParameter("pEstadoNome", nome);
		query.setParameter("pPaisId", pais.getId());
		List<?> list = query.getResultList();
		if(list.size() > 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este país já possui um estado cadastrado com este nome");
		}
		
	}

}


