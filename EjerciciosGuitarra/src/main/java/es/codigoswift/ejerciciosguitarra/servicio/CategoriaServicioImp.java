package es.codigoswift.ejerciciosguitarra.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.codigoswift.ejerciciosguitarra.modelo.Categoria;
import es.codigoswift.ejerciciosguitarra.repositorio.CategoriaRepositorio;


@Service
public class CategoriaServicioImp implements CategoriaServicio {

	@Autowired
	CategoriaRepositorio categoriaRepositorio;
	
	@Override
	public List<Categoria> findAll() {
		return categoriaRepositorio.findAll();
	}

	@Override
	public List<Categoria> findAllByOrderByNombreAsc() {
		return categoriaRepositorio.findAllByOrderByNombreAsc();
	}

	@Override
	public Optional<Categoria> findById(Integer id) {
		return categoriaRepositorio.findById(id);
	}

	@Override
	public Categoria save(Categoria categoria) {
		return categoriaRepositorio.save(categoria);
	}

}
