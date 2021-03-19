package zup.com.br.casadocodigotreino.Validation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Documented
@Constraint(validatedBy = {StateCountryValidator.class})
@Target({ ElementType.TYPE})
@Retention(RUNTIME)
public @interface StateCountry {
	
	String message() default "Insira o id de pais e um estado valido!";
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default { };
}
