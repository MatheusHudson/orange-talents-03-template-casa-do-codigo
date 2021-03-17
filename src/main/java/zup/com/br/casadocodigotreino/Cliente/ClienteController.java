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

	 
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}



	@PostMapping
	@Transactional
	public ResponseEntity<ClienteForm> cadastrarCliente(@RequestBody @Valid ClienteForm form) {
		
		clienteService.salvarCliente(form);
		return ResponseEntity.ok(form);
	}
	
	
}
