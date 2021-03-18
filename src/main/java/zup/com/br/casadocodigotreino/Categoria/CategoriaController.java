package zup.com.br.casadocodigotreino.Categoria;



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
@RequestMapping("/categorias")
public class CategoriaController {
	

		@PersistenceContext
		private EntityManager manager;
		

		@PostMapping
		@Transactional
		public ResponseEntity<CategoriaForm> categoria(@RequestBody @Valid CategoriaForm form) {
			
			Categoria categoria = form.toModel();
			manager.persist(categoria);
		
			return ResponseEntity.status(HttpStatus.OK).body(form);
			
		}
}
