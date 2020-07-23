package es.codigoswift.ejerciciosguitarra.servicio;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.codigoswift.ejerciciosguitarra.modelo.Ejercicio;
import es.codigoswift.ejerciciosguitarra.repositorio.EjercicioRepositorio;

@Service
@Transactional
public class EjercicioServicioImp implements EjercicioServicio {

	@Autowired
	EjercicioRepositorio ejercicioRepositorio;
	
	@Override
	public Ejercicio save(Ejercicio ejercicio) {
		return ejercicioRepositorio.save(ejercicio);
	}

	@Override
	public List<Ejercicio> findAll() {
		return ejercicioRepositorio.findAll();
	}

}
