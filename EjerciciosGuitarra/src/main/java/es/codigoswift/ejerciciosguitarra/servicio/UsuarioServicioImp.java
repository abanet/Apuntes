package es.codigoswift.ejerciciosguitarra.servicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.codigoswift.ejerciciosguitarra.modelo.Usuario;
import es.codigoswift.ejerciciosguitarra.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicioImp implements UsuarioServicio {

	@Autowired
	UsuarioRepositorio usuarioRepositorio;
	
	@Override
	public Optional<Usuario> findById(Integer id) {
		return usuarioRepositorio.findById(id);
	}

	@Override
	public Usuario save(Usuario usuario) {
		return usuarioRepositorio.save(usuario);
	}

}
