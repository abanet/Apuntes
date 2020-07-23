package es.codigoswift.ejerciciosguitarra.servicio;

import java.util.Optional;

import org.springframework.stereotype.Service;

import es.codigoswift.ejerciciosguitarra.modelo.Ejercicio;
import es.codigoswift.ejerciciosguitarra.modelo.Usuario;



@Service
public interface UsuarioServicio {
	
	public Optional<Usuario> findById(Integer id);
	
	public Usuario save(Usuario usuario);
}
