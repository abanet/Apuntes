package es.codigoswift.ejerciciosguitarra.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import es.codigoswift.ejerciciosguitarra.modelo.Categoria;

@Service
public interface CategoriaServicio {
	public List<Categoria> findAll();
	public List<Categoria> findAllByOrderByNombreAsc();
	public Optional<Categoria> findById(Integer id);
	public Categoria save(Categoria categoria);
}
