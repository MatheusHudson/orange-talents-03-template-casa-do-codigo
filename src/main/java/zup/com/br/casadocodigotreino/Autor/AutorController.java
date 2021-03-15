package zup.com.br.casadocodigotreino.Autor;

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

import zup.com.br.casadocodigotreino.Validation.ProibeEmailDuplicadoAutorValidator;

@RestController
@RequestMapping("/autores")
public class AutorController {
	
	private ProibeEmailDuplicadoAutorValidator proibeEmailDuplicadoAutorValidator;
	
	public AutorController (ProibeEmailDuplicadoAutorValidator proibeEmailDuplicadoAutorValidator) {
		this.proibeEmailDuplicadoAutorValidator = proibeEmailDuplicadoAutorValidator;
	}
	
	
	@PersistenceContext
	private EntityManager manager;
	

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(proibeEmailDuplicadoAutorValidator);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<AutorForm> cadastrarAutor(@RequestBody @Valid AutorForm autorCadastro,
			UriComponentsBuilder uriBuilder) {

		Autor autor = autorCadastro.converter(autorCadastro);
		manager.persist(autor);

		URI uri = uriBuilder.path("/autores/{id}").buildAndExpand(autor.getId()).toUri();
		return ResponseEntity.created(uri).body(autorCadastro);
	}
}
