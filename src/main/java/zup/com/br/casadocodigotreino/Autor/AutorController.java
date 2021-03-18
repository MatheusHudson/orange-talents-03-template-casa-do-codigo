package zup.com.br.casadocodigotreino.Autor;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/autores")
public class AutorController {
	

	@PersistenceContext
	private EntityManager manager;
	

	@PostMapping
	@Transactional
	public ResponseEntity<AutorForm> cadastrarAutor(@RequestBody @Valid AutorForm autorCadastro) {

		Autor autor = autorCadastro.toModel(autorCadastro);
		manager.persist(autor);
		return ResponseEntity.status(HttpStatus.OK).body(autorCadastro);
	}
}
