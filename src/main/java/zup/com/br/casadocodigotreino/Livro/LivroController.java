package zup.com.br.casadocodigotreino.Livro;

import java.net.URI;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import zup.com.br.casadocodigotreino.Autor.AutorRepository;
import zup.com.br.casadocodigotreino.Categoria.CategoriaRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	private final AutorRepository autorRepository;
	private final CategoriaRepository categoriaRepository;
	
	
		
	public LivroController(AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
		super();
		this.autorRepository = autorRepository;
		this.categoriaRepository = categoriaRepository;
	}

	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping
	@Transactional
	public ResponseEntity<LivroForm> cadastrarLivro(@RequestBody @Valid LivroForm form,UriComponentsBuilder uriBuilder ) {
		
		Livro livro = form.converter(autorRepository, categoriaRepository);
		manager.persist(livro);
		
		URI uri = uriBuilder.path("/livros/{isdn}").buildAndExpand(livro.getIsbn()).toUri();
		return ResponseEntity.created(uri).body(form);
	}
}
