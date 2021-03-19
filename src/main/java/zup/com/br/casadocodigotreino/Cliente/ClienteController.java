package zup.com.br.casadocodigotreino.Cliente;



import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	

	private final ClienteRepository clienteRepository;
	 
	public ClienteController(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}



	@PostMapping
	@Transactional
	public ResponseEntity<ClienteForm> cadastrarCliente(@RequestBody @Valid ClienteForm form) {
		
	
		Cliente cliente = form.toModel();
		clienteRepository.save(cliente);
		
		return ResponseEntity.ok(form);
	}
	
	
}
