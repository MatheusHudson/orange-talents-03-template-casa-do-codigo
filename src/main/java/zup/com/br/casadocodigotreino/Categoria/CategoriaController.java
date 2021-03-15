package zup.com.br.casadocodigotreino.Categoria;

import java.net.URI;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import zup.com.br.casadocodigotreino.Validation.ProibeNomeDuplicadoCategoriaValidator;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
		private final ProibeNomeDuplicadoCategoriaValidator proibeNomeDuplicadoCategoriaValidator;
		
		
		
		public CategoriaController(ProibeNomeDuplicadoCategoriaValidator proibeNomeDuplicadoCategoriaValidator) {
			this.proibeNomeDuplicadoCategoriaValidator = proibeNomeDuplicadoCategoriaValidator;
		}

		@PersistenceContext
		private EntityManager manager;
		
		@InitBinder
		public void init(WebDataBinder binder) {
			binder.addValidators(proibeNomeDuplicadoCategoriaValidator);
		}
		
		@PostMapping
		@Transactional
		public ResponseEntity<CategoriaForm> categoria(@RequestBody @Valid CategoriaForm form, UriComponentsBuilder uriBuilder) {
			
			Categoria categoria = form.converter();
			manager.persist(categoria);
			
			URI uri = uriBuilder.path("/categorias/{id}").buildAndExpand(categoria.getId()).toUri();
			return ResponseEntity.created(uri).body(form);
			
		}
}
