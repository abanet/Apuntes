package es.codigoswift.ejerciciosguitarra.servicio;

import java.util.List;

import es.codigoswift.ejerciciosguitarra.beans.MenuBean;
import es.codigoswift.ejerciciosguitarra.modelo.Usuario;

/**
 * Servicio de acceso a los datos de sesión del usuario actual
 * 
 * @author abanet
 *
 */
public interface SesionServicio {
	
	
	
	/**
	 * Obtener menú del usuario actual
	 * 
	 * @return List<MenuBean>
	 */
	public List<MenuBean> getMenu();
	
	/**
	 * Método que devuelve el email del usuario actual
	 * 
	 * @return String
	 */
	public String getEmail();
}