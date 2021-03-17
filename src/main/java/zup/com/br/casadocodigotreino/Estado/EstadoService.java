package zup.com.br.casadocodigotreino.Estado;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import zup.com.br.casadocodigotreino.Pais.Pais;
//4
@Service
public class EstadoService {

	private final EstadoRepository estadoRepository;
	
	public EstadoService(EstadoRepository estadoRepository) {
		this.estadoRepository = estadoRepository;
	}
	
	
	public boolean isValidEstado(Pais pais, EstadoForm estado) {
		
		Optional<?> lista = estadoRepository.filtrarEstadoEmPais(estado.getNome(), estado.getPais().getId());
		if(lista.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este país já possui um estado cadastrado com este nome");
		}	
		return true;
	}
	
	public void salvarEstado (EstadoForm form) {
		Optional<Pais> estadoP = estadoRepository.buscarPaisPorId(form.getPais().getId());
		if(!estadoP.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi possivel encontra um pais com este id");
		}
		isValidEstado(form.getPais(), form);
		Estado estado = new Estado(form.getNome(), form.getPais());
		estadoP.get().getEstados().add(estado);
		estadoRepository.save(estado);
	}
}
