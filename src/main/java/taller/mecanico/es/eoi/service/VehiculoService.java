package taller.mecanico.es.eoi.service;

import java.util.List;
import java.util.Optional;

import taller.mecanico.es.eoi.entity.Reparacion;
import taller.mecanico.es.eoi.entity.Vehiculos;

public interface VehiculoService {
	
	List<Vehiculos> findAll();

	Vehiculos save(Vehiculos vehiculos);

	Optional<Vehiculos> findById(String matricula);

	Vehiculos update(Vehiculos vehiculos);

	 void delete(String  matricula);
	List<Reparacion> findByMatricula_Dni(String matricula);
}
