package zup.com.br.casadocodigotreino.Cliente;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import zup.com.br.casadocodigotreino.Pais.Pais;

@Service
public class ClienteService {

	private final ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public Boolean isValidCliente(ClienteForm form) {

		Optional<Pais> pais = clienteRepository.findPaisById(form.getPais().getId());
		if (pais.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Insira um id de pais valido cadastrado no banco de dados");
		}
			if (form.getEstado() == null) 
				return true;
			Optional<?> list = clienteRepository.findStateCountryById(form.getEstado().getId(), pais.get().getId());

			if (list.isEmpty()) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
						"Insira um id de estado valido cadastrado no banco de dado para este país");
			}
		

		return true;
	}
}
