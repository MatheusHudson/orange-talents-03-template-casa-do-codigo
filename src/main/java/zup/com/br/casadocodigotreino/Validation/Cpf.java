package zup.com.br.casadocodigotreino.Validation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Documented
@Constraint(validatedBy = {CpfValidator.class})
@Target({ ElementType.TYPE})
@Retention(RUNTIME)
public @interface Cpf {
	
	String message() default "Insira um cpf ou um cnpj valido";
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default { };
}
