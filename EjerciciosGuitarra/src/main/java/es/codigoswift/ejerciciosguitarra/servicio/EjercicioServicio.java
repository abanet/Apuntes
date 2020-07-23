package es.codigoswift.ejerciciosguitarra.servicio;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import es.codigoswift.ejerciciosguitarra.modelo.Ejercicio;

@Service
public interface EjercicioServicio {

	@Transactional()
	public Ejercicio save(Ejercicio ejercicio);
	
	public List<Ejercicio> findAll();
}
