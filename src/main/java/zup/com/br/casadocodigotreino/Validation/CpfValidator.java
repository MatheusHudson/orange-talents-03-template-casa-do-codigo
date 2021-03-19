package zup.com.br.casadocodigotreino.Validation;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import zup.com.br.casadocodigotreino.Cliente.ClienteForm;

public class CpfValidator implements ConstraintValidator<Cpf, ClienteForm>{
	

	@PersistenceContext
	private EntityManager manager;


	@Override
	public boolean isValid(ClienteForm value, ConstraintValidatorContext context) {
			
		if( (value.getCpf() == null && value.getCnpj() == null) || (value.getCpf() != null && value.getCnpj() != null )) {
				return false;
		}

		return true;
			
	}

}