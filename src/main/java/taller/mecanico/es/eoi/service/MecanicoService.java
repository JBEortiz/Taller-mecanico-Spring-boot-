package taller.mecanico.es.eoi.service;

import java.util.List;
import java.util.Optional;

import taller.mecanico.es.eoi.entity.Aparcamiento;
import taller.mecanico.es.eoi.entity.Mecanicos;
import taller.mecanico.es.eoi.entity.Reparacion;

public interface MecanicoService {
	
	List<Mecanicos> findAll();

	Mecanicos save(Mecanicos mecanicos);

	Optional<Mecanicos> findById(String dni);

	Mecanicos update(Mecanicos mecanicos);

	public void delete(String dni);
	
    Mecanicos asociarPlazaMecanico(String dni, Aparcamiento aparcamiento);
    List<Reparacion> findByMecanico_Dni(String dni);
  
}
