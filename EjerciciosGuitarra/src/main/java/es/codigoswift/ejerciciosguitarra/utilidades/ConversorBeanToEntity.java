package es.codigoswift.ejerciciosguitarra.utilidades;

import es.codigoswift.ejerciciosguitarra.beans.EjercicioBean;
import es.codigoswift.ejerciciosguitarra.modelo.Ejercicio;

public class ConversorBeanToEntity {
	public static Ejercicio ejercicioBeanToEntity (EjercicioBean ejercicioBean) {
		Ejercicio ejercicio = new Ejercicio();
		if(ejercicioBean.getId() != null) {
			ejercicio.setId(ejercicioBean.getId());
		}
		ejercicio.setNombre(ejercicioBean.getNombre());
		ejercicio.setDescripcion(ejercicioBean.getDescripcion());
		ejercicio.setCodigoYoutube(ejercicioBean.getCodigoYoutube());
		ejercicio.setFechaCreacion(ejercicioBean.getFechaCreacion());
		ejercicio.setFechaModificacion(ejercicioBean.getFechaModificacion());
		ejercicio.setActivo(ejercicioBean.getActivo());
		ejercicio.setUsuario(ejercicioBean.getUsuario());
		return ejercicio;
	}
}
