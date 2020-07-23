package es.codigoswift.ejerciciosguitarra.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.codigoswift.ejerciciosguitarra.modelo.Categoria;
import es.codigoswift.ejerciciosguitarra.modelo.Subcategoria;
import es.codigoswift.ejerciciosguitarra.repositorio.SubcategoriaRepositorio;

@Service
public class SubcategoriaServicioImp implements SubcategoriaServicio{

	@Autowired
	SubcategoriaRepositorio subcategoriaRepositorio;
	
	@Override
	public List<Subcategoria> findAll() {
		return subcategoriaRepositorio.findAll();
	}

	@Override
	public List<Subcategoria> findByCategoria(Categoria categoria) {
		return subcategoriaRepositorio.findByCategoria(categoria);
	}

	@Override
	public void deleteById(Integer id) {
		subcategoriaRepositorio.deleteById(id);
	}

	@Override
	public void save(Subcategoria subcategoria) {
		subcategoriaRepositorio.save(subcategoria);
	}

	
}
