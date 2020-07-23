package es.codigoswift.ejerciciosguitarra.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import es.codigoswift.ejerciciosguitarra.beans.CategoriaBean;
import es.codigoswift.ejerciciosguitarra.modelo.Categoria;
import es.codigoswift.ejerciciosguitarra.modelo.Subcategoria;
import es.codigoswift.ejerciciosguitarra.servicio.CategoriaServicio;
import es.codigoswift.ejerciciosguitarra.servicio.SubcategoriaServicio;
import es.codigoswift.ejerciciosguitarra.utilidades.ConversorEntityToBean;

@Controller
@RequestMapping("/categorias")
public class CategoriasController {

	@Autowired
	CategoriaServicio categoriaServicio;
	
	@Autowired
	SubcategoriaServicio subcategoriaServicio;
	
	
	
	/**
	 * Vista con selector de categoría principal para mostrar sus subcategorias
	 */
	@GetMapping({"/categorias", "/", ""})
	public ModelAndView gestionCategorias (HttpServletRequest request) {
		ModelAndView vista = new ModelAndView("categorias2");
		List<Categoria> categorias = categoriaServicio.findAllByOrderByNombreAsc();
		List<CategoriaBean> categoriasBean = ConversorEntityToBean.categoriasBeanToEntity(categorias);
		vista.addObject("categorias", categoriasBean);
		
		// Si hay mensajes desde la grabación de una categoría la mostramos en la pantalla
		String mensaje = null;
		Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
		if (inputFlashMap != null) {
			mensaje = (String) inputFlashMap.get("mensaje");
		}
		vista.addObject("mensaje", mensaje);
		
		return vista;
	}
	
	/*
	 * @GetMapping("/categorias2") public ModelAndView gestionCategorias2
	 * (HttpServletRequest request) { ModelAndView vista = new
	 * ModelAndView("categorias2"); List<Categoria> categorias =
	 * categoriaServicio.findAllByOrderByNombreAsc(); List<CategoriaBean>
	 * categoriasBean = ConversorEntityToBean.categoriasBeanToEntity(categorias);
	 * vista.addObject("categorias", categoriasBean);
	 * 
	 * // Si hay mensajes desde la grabación de una categoría la mostramos en la
	 * pantalla String mensaje = null; Map<String, ?> inputFlashMap =
	 * RequestContextUtils.getInputFlashMap(request); if (inputFlashMap != null) {
	 * mensaje = (String) inputFlashMap.get("mensaje"); } vista.addObject("mensaje",
	 * mensaje);
	 * 
	 * return vista; }
	 */
	
	@GetMapping("/subcategorias/{idCategoria}")
	public String cargarSubcategorias(@PathVariable("idCategoria") Integer id, Model modelo) {
		Optional<Categoria> categoria = categoriaServicio.findById(id);
		List<Subcategoria> sub = new ArrayList<Subcategoria>();
		if (categoria.isPresent()) {
			sub = categoria.get().getSubcategorias();
		}
		modelo.addAttribute("subcategorias", sub);
		return "categorias :: #categoriassecundarias";
	}
	
	
	/**
	 * Devuelve las subcategorías de una categoría determinada en formato json
	 * @param id de la categoría
	 * @return
	 */
	@GetMapping("/subcategoriasjson/{idCategoria}")
	@ResponseBody
	public List<Subcategoria> cargarSubcategorias2(@PathVariable("idCategoria") Integer id) {
		Optional<Categoria> categoria = categoriaServicio.findById(id);
		List<Subcategoria> sub = new ArrayList<Subcategoria>();
		if (categoria.isPresent()) {
			sub = categoria.get().getSubcategorias();
		}
		return sub;
	}
	
	@GetMapping("eliminarSubcategoria/{idSubcategoria}")
	public String eliminarSubcategoria(@PathVariable("idSubcategoria") Integer id) {
		subcategoriaServicio.deleteById(id);
		return "redirect:/categorias";
		
	}
	
}
