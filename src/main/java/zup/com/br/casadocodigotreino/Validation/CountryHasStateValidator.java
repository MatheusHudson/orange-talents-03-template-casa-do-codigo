package zup.com.br.casadocodigotreino.Validation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

import zup.com.br.casadocodigotreino.Pais.Pais;

public class CountryHasStateValidator implements ConstraintValidator<CountryHasState, Object>{
	
	private Pais pais;
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void initialize(CountryHasState params) {

	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		pais = (Pais) value;
		Query query = manager.createQuery("select p.estados from Pais p Where p.id = :value");
		query.setParameter("value", pais.getId());
		List<?> list = query.getResultList();
		Assert.state(list.size() <= 1, "Este país possui estados e é necessário passar um estado valido cadastrado!");
		
		return list.isEmpty();
	}

}