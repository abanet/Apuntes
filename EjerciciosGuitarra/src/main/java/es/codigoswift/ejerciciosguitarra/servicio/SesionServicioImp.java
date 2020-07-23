package es.codigoswift.ejerciciosguitarra.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.codigoswift.ejerciciosguitarra.beans.MenuBean;

	@Service
	public class SesionServicioImp implements SesionServicio {


		@Override
		public List<MenuBean> getMenu() {
			List<MenuBean> menuPrincipal = null;
			List<MenuBean> menuSecundario = null;
			MenuBean opcionSecundaria = null;
			MenuBean opcionPrincipal = null;

			menuPrincipal = new ArrayList<MenuBean>();
			
			// Menu para administrador TODO: en un futuro controlar por Rol
			
			// Opción principal
			opcionPrincipal = new MenuBean("Inicio", "http://localhost:8080/inicio", null);
			menuPrincipal.add(opcionPrincipal);
			
			// Opción de ejercicios
			menuSecundario = new ArrayList<MenuBean>();
			opcionSecundaria = new MenuBean("Nuevo Ejercicio", "/ejercicios/form", null);
			menuSecundario.add(opcionSecundaria);
			opcionSecundaria = new MenuBean("Lista ejercicios", "/ejercicios/listado", null);
			menuSecundario.add(opcionSecundaria);
			opcionPrincipal = new MenuBean("Ejercicios", "/ejercicios/", menuSecundario);
			menuPrincipal.add(opcionPrincipal);
			
			
			// Opción de categorias
			opcionPrincipal = new MenuBean("Categorias", "/categorias/", null);
			menuPrincipal.add(opcionPrincipal);
			
			return menuPrincipal;
		}

		@Override
		public String getEmail() {
			// TODO Devolver el email del usuario
			return "alberto@gmail.com";
		}

	}


