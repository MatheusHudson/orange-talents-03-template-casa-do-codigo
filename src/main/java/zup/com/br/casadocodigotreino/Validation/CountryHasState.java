package zup.com.br.casadocodigotreino.Validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import zup.com.br.casadocodigotreino.Pais.Pais;


@Documented
@Constraint(validatedBy = {CountryHasStateValidator.class})
@Target({ FIELD})
@Retention(RUNTIME)
public @interface CountryHasState {
	
	String message() default "Este país possui Estados, e um precisa ser selecionado!";
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default { };
	
	
}
