package es.codigoswift.ejerciciosguitarra.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import es.codigoswift.ejerciciosguitarra.modelo.Categoria;
import es.codigoswift.ejerciciosguitarra.modelo.Subcategoria;

@Service
public interface SubcategoriaServicio {
	public List<Subcategoria> findAll();
	public List<Subcategoria> findByCategoria(Categoria categoria);
	public void deleteById(Integer id);
}
