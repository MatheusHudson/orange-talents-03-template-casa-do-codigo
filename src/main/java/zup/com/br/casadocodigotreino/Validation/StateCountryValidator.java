package zup.com.br.casadocodigotreino.Validation;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import zup.com.br.casadocodigotreino.Cliente.ClienteForm;
import zup.com.br.casadocodigotreino.Cliente.ClienteRepository;
import zup.com.br.casadocodigotreino.Pais.Pais;

public class StateCountryValidator implements ConstraintValidator<StateCountry, ClienteForm> {

	private final ClienteRepository clienteRepository;

	public StateCountryValidator(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	@Override
	public boolean isValid(ClienteForm form, ConstraintValidatorContext context) {

		Optional<Pais> pais = clienteRepository.findPaisById(form.getPais().getId());
		if (pais.isEmpty()) {
			return false;
		}
		if (form.getEstado() == null)
			return true;
		Optional<?> list = clienteRepository.findStateCountryById(form.getEstado().getId(), pais.get().getId());
		if (list.isEmpty()) {
			return false;
		}

		return true;

	}

}