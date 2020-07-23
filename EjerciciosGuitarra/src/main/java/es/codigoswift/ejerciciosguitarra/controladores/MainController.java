package es.codigoswift.ejerciciosguitarra.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import es.codigoswift.ejerciciosguitarra.beans.MenuBean;
import es.codigoswift.ejerciciosguitarra.servicio.SesionServicio;

@Controller
public class MainController {
	
		
		
		@GetMapping({"", "/", "/home", "/inicio"})
		public ModelAndView home() {
			ModelAndView vista = new ModelAndView("inicio");
			return vista;
		}
		
		@GetMapping("/menu")
		public ModelAndView menu() {
			ModelAndView vista = new ModelAndView("menu");
			return vista;
		}
	
}
