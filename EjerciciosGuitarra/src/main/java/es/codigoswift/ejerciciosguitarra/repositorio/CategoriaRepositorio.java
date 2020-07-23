package es.codigoswift.ejerciciosguitarra.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codigoswift.ejerciciosguitarra.modelo.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Integer> {

	public List<Categoria> findAll();
	public List<Categoria> findAllByOrderByNombreAsc();
	public Categoria save(Categoria categoria);
	
}
