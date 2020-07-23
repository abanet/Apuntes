package es.codigoswift.ejerciciosguitarra.utilidades;

import java.util.ArrayList;
import java.util.List;

import es.codigoswift.ejerciciosguitarra.beans.CategoriaBean;
import es.codigoswift.ejerciciosguitarra.beans.EjercicioBean;
import es.codigoswift.ejerciciosguitarra.modelo.Categoria;
import es.codigoswift.ejerciciosguitarra.modelo.Ejercicio;

public class ConversorEntityToBean {

	
	public static EjercicioBean ejercicioBeanToEntity(Ejercicio ejercicio) {
		EjercicioBean eb = new EjercicioBean();
		eb.setId(ejercicio.getId());
		eb.setNombre(ejercicio.getNombre());
		eb.setDescripcion(ejercicio.getDescripcion());
		eb.setCodigoYoutube(ejercicio.getCodigoYoutube());
		eb.setFechaCreacion(ejercicio.getFechaCreacion());
		eb.setFechaModificacion(ejercicio.getFechaModificacion());
		eb.setActivo(ejercicio.getActivo());
		eb.setUsuario(ejercicio.getUsuario());
		return eb;
	}
	
	public static List<EjercicioBean> ejerciciosBeanToEntity(List<Ejercicio> ejercicios) {
		List<EjercicioBean> listaBean = new ArrayList<EjercicioBean>();
		for (Ejercicio ejercicio : ejercicios) {
			listaBean.add(ejercicioBeanToEntity(ejercicio));
		}
		return listaBean;
	}

	public static List<CategoriaBean> categoriasBeanToEntity(List<Categoria> categorias) {
		List<CategoriaBean> listaBean = new ArrayList<CategoriaBean>();
		for (Categoria categoria : categorias) {
			listaBean.add(categoriaBeanToEntity(categoria));
		}
		return listaBean;
	}

	private static CategoriaBean categoriaBeanToEntity(Categoria categoria) {
		CategoriaBean cat = new CategoriaBean();
		cat.setId(categoria.getId());
		cat.setNombre(categoria.getNombre());
		return cat;
	}

}

