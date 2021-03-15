package zup.com.br.casadocodigotreino.Validation;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import zup.com.br.casadocodigotreino.Autor.Autor;
import zup.com.br.casadocodigotreino.Autor.AutorForm;
import zup.com.br.casadocodigotreino.Autor.AutorRepository;

@Component
public class ProibeEmailDuplicadoAutorValidator implements Validator {

	private final AutorRepository autorRepository;
	
	public ProibeEmailDuplicadoAutorValidator(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return AutorForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors())  {
			return;
		}
	
		AutorForm request = (AutorForm) target;
		
		Optional<Autor> possivelAutor = autorRepository.findByEmail(request.getEmail());
		
		if(possivelAutor.isPresent()) {
			errors.rejectValue("email", null, "Já existe um(a) outro(a) com o mesmo email: " + request.getEmail());
		}
		
	}

}
