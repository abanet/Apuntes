package es.codigoswift.ejerciciosguitarra.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import es.codigoswift.ejerciciosguitarra.beans.EjercicioBean;



@Component
public class EjercicioValidador implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return EjercicioBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		EjercicioBean ejercicio = (EjercicioBean) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "requerido");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "codigoYoutube", "requerido");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descripcion", "requerido");

	}

}
