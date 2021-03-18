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
	
	private final ClienteService clienteService;
	private final ClienteRepository clienteRepository;
	 
	public ClienteController(ClienteService clienteService, ClienteRepository clienteRepository) {
		this.clienteService = clienteService;
		this.clienteRepository = clienteRepository;
	}



	@PostMapping
	@Transactional
	public ResponseEntity<ClienteForm> cadastrarCliente(@RequestBody @Valid ClienteForm form) {
		
		clienteService.isValidCliente(form);
		Cliente cliente = form.toModel(form);
		clienteRepository.save(cliente);
		
		return ResponseEntity.ok(form);
	}
	
	
}
