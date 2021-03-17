package zup.com.br.casadocodigotreino.Estado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estados")
public class EstadoController {
	
	@PersistenceContext
	EntityManager manager;

	@PostMapping
	@Transactional
	public ResponseEntity<EstadoForm> cadastrarEstado(@RequestBody @Valid EstadoForm form) {
			
		Estado estado = form.converter(manager);
		manager.persist(estado);
		
		return ResponseEntity.ok(form);
		
	}
}
