package es.codigoswift.ejerciciosguitarra.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import es.codigoswift.ejerciciosguitarra.modelo.Usuario;


public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {

}
