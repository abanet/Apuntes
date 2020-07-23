package es.codigoswift.ejerciciosguitarra.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.codigoswift.ejerciciosguitarra.beans.MenuBean;

/**
 * @author alberto
 *
 * Componente creado para usar directamente desde thymeleaf @thymeleafExpressions.metodo(...) dentro de una expresión Thymeleaf ${...}
 */

@Component
public class ThymeleafExpressions {

	@Autowired
	SesionServicio sesionServicio;
	
	
	/**
	 * Método que devuelve el menu del usuario.
	 */
	public List<MenuBean> getMenu() {
		List<MenuBean> menu = sesionServicio.getMenu();
		return menu;
	}
	
	/**
	 * Método que devuelve el eMail del usuario para ponerlo en el pie de página.
	 * 
	 * @return String
	 */
	public String getEmailUsuario() {
		return sesionServicio.getEmail();
	}
	
	/**
	 * Método que devuelve el centro del usuario para ponerlo en el pie de página.
	 */
	public String getPieDerecho() {
		return "Administrador";
	}
}
