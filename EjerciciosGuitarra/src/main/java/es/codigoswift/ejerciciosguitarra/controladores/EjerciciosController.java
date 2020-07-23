package es.codigoswift.ejerciciosguitarra.controladores;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

import es.codigoswift.ejerciciosguitarra.beans.EjercicioBean;
import es.codigoswift.ejerciciosguitarra.modelo.Ejercicio;
import es.codigoswift.ejerciciosguitarra.modelo.Usuario;
import es.codigoswift.ejerciciosguitarra.servicio.EjercicioServicio;
import es.codigoswift.ejerciciosguitarra.servicio.UsuarioServicio;
import es.codigoswift.ejerciciosguitarra.utilidades.ConversorBeanToEntity;
import es.codigoswift.ejerciciosguitarra.utilidades.ConversorEntityToBean;
import es.codigoswift.ejerciciosguitarra.validators.EjercicioValidador;



@Controller
@RequestMapping("/ejercicios")
public class EjerciciosController {
	
	@Autowired
	private EjercicioServicio ejercicioServicio;
	
	@Autowired
	private UsuarioServicio usuarioServicio;
	
	@Autowired
	private EjercicioValidador ejercicioValidador;

	@InitBinder
	public  void initBinder(WebDataBinder binder) {
		binder.setValidator(ejercicioValidador);
	}
	
	/**
	 * Vista con un listado de todos los ejercicios disponibles
	 */
	@GetMapping({"/listado", "/"})
	public ModelAndView listadoEjercicios(HttpServletRequest request) {
		ModelAndView vista = new ModelAndView("listado");
		List<Ejercicio> ejercicios = ejercicioServicio.findAll();
		List<EjercicioBean> ejerciciosBean = ConversorEntityToBean.ejerciciosBeanToEntity(ejercicios);
		vista.addObject("ejercicios", ejerciciosBean);
		
		// Si hay mensajes desde la grabación de un nuevo ejercicio lo mostramos en pantalla
		String mensaje = null;
		Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
		if (inputFlashMap != null) {
			mensaje = (String) inputFlashMap.get("mensaje");
		}
		vista.addObject("mensaje", mensaje);
		
		return vista;
	}
	
	@GetMapping("/form")
	public ModelAndView form(@ModelAttribute("ejercicio") EjercicioBean ejercicio) {
		ModelAndView vista = new ModelAndView("ejercicioForm");
		vista.addObject(ejercicio);
		return vista;
	}
	
	@PostMapping("/form")
	public ModelAndView procesarFormulario(@Valid @ModelAttribute("ejercicio") EjercicioBean ejercicioBean, BindingResult result, RedirectAttributes redirectAttributes) {
		ModelAndView vista = new ModelAndView("resultado");
		
		Optional<Usuario> usuario = usuarioServicio.findById(11);
		
		//Convertir EjercicioBean a Ejercicio para grabarlo.
		Ejercicio ejercicio = ConversorBeanToEntity.ejercicioBeanToEntity(ejercicioBean);
		
		if(usuario.isPresent()) {
			ejercicio.setUsuario(usuario.get());
		}
		
		ejercicioServicio.save(ejercicio);
		vista.addObject(ejercicio);
		
		if(result.hasErrors()) {
			ModelAndView vistaFormulario = new ModelAndView("ejercicioForm");
			return vistaFormulario;
		} else {
			// redirect al listado de elementos
			redirectAttributes.addFlashAttribute("mensaje", "Ejercicio guardado correctamente");
			return new ModelAndView(new RedirectView("/ejercicios/listado", true));	
		}

		
	}
}
