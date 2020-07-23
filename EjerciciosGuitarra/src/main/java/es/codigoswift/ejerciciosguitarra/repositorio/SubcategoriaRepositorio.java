package es.codigoswift.ejerciciosguitarra.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.codigoswift.ejerciciosguitarra.modelo.Categoria;
import es.codigoswift.ejerciciosguitarra.modelo.Subcategoria;

@Repository
public interface SubcategoriaRepositorio extends JpaRepository<Subcategoria, Integer> {
	public List<Subcategoria> findByCategoria(Categoria categoria);
	public void deleteById(Integer id);
	
}
