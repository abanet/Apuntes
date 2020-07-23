package es.codigoswift.ejerciciosguitarra.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.codigoswift.ejerciciosguitarra.modelo.Ejercicio;


public interface EjercicioRepositorio extends JpaRepository<Ejercicio, Integer> {

}
