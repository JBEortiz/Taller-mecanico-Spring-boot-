package taller.mecanico.es.eoi.service;

import java.util.List;
import java.util.Optional;

import taller.mecanico.es.eoi.entity.Aparcamiento;

public interface AparcamientoService {
	List<Aparcamiento> findAll();

	Aparcamiento save(Aparcamiento aparcamiento);

	Optional<Aparcamiento> findById(Long id);

	Aparcamiento update(Aparcamiento aparcamiento);

	void delete(Aparcamiento aparcamiento);

}
