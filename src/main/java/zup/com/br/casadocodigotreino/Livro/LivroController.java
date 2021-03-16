package zup.com.br.casadocodigotreino.Livro;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;






@RestController
@RequestMapping("/livros")

public class LivroController {


	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping
	@Transactional
	public ResponseEntity<LivroForm> cadastrarLivro(@RequestBody @Valid LivroForm form,UriComponentsBuilder uriBuilder ) {
		
		Livro livro =  form.converter(manager);
		manager.persist(livro);
	
		
		URI uri = uriBuilder.path("/livros/{id}").buildAndExpand(livro.getId()).toUri();
		return ResponseEntity.status(HttpStatus.OK).body(form);
	}
	
	@GetMapping
	@Transactional
	public ResponseEntity<List<LivroForm>> listarLivros() {
		 
	  List<Livro> livros =  (List<Livro>) manager.createQuery("Select l From Livro l").getResultList();
	  List<LivroForm> livrosForm =  livros.stream().map(LivroForm::new).collect(Collectors.toList());
		
		return ResponseEntity.ok(livrosForm);
	}
	
	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity<LivroForm> listarLivro(@PathVariable Integer id) {
		 
		Livro livro =  manager.find(Livro.class, id);
		if(livro == null) {	
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Não foi encontra um livro no nosso banco com este id cadastrado");
		}
		
		return ResponseEntity.ok(new LivroForm(livro));
		
		
	}
	
	 
}
