package br.com.zupacademy.marcio.casadocodigo.validator;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@CPF
@CNPJ
@Documented
@Constraint(validatedBy = { })
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDocumento {

    String message() default "CPF ou CNPJ inválidos";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
