package zup.com.br.casadocodigotreino.Validation;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import zup.com.br.casadocodigotreino.Categoria.Categoria;
import zup.com.br.casadocodigotreino.Categoria.CategoriaForm;
import zup.com.br.casadocodigotreino.Categoria.CategoriaRepository;

@Component
public class ProibeNomeDuplicadoCategoriaValidator implements Validator {

	private final CategoriaRepository categoriaRepository;
	
	public ProibeNomeDuplicadoCategoriaValidator(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return CategoriaForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors())  {
			return;
		}
	
		CategoriaForm request = (CategoriaForm) target;
		
		Optional<Categoria> possivelCategoria = categoriaRepository.findByNome(request.getNome());
		
		if(possivelCategoria.isPresent()) {
			errors.rejectValue("nome", null, "Já existe um(a) outro(a) com o mesmo nome: " + request.getNome());
		}
		
	}

}
