package taller.mecanico.es.eoi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import taller.mecanico.es.eoi.entity.Reparacion;
import taller.mecanico.es.eoi.entity.Vehiculos;
import taller.mecanico.es.eoi.repository.VehiculosRepository;
@Service
public class VehiculoServiceImpl implements VehiculoService{

	@Autowired
	private VehiculosRepository repository;
	@Override
	public List<Vehiculos> findAll() {
		return repository.findAll();
	}

	@Override
	public Vehiculos save(Vehiculos vehiculos) {
		return repository.save(vehiculos);
	}

	@Override
	public 	Optional<Vehiculos> findById(String matricula){
		return repository.findById(matricula);
	}

	@Override
	public Vehiculos update(Vehiculos vehiculos) {
		Vehiculos vehiculoUpdate= new Vehiculos();
		vehiculoUpdate.setMatricula(vehiculos.getMatricula());
		return repository.save(vehiculoUpdate);
	}

	@Override
	public void delete(String  matricula) {
		repository.deleteById(matricula);
	}

	@Override
	public List<Reparacion> findByMatricula_Dni(String matricula) {
		return repository.findByMatricula_Dni(matricula);
	}

}
