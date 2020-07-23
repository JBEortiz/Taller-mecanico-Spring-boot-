package taller.mecanico.es.eoi.service;

import java.util.List;
import java.util.Optional;

import taller.mecanico.es.eoi.entity.Reparacion;

public interface ReparacionService {
	List<Reparacion> findAll();

	Reparacion save(Reparacion reparacion);

	Optional<Reparacion> findById(Long id);

	Reparacion update(Reparacion reparacion);

	void delete(Long id);
	
	List<Reparacion> findByMecanico_Dni(String dni);
	
	List<Reparacion> findByMatricula_Dni(String matricula);
}
