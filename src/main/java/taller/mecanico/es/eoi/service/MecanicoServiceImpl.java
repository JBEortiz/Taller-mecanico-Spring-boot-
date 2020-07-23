package taller.mecanico.es.eoi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import taller.mecanico.es.eoi.entity.Aparcamiento;
import taller.mecanico.es.eoi.entity.Mecanicos;
import taller.mecanico.es.eoi.entity.Reparacion;
import taller.mecanico.es.eoi.repository.AparcamientoRepository;
import taller.mecanico.es.eoi.repository.MecanicoRepository;
@Service
public class MecanicoServiceImpl implements MecanicoService{

	@Autowired
	private MecanicoRepository repository;
	
	@Autowired
	private AparcamientoRepository aRepository;
	@Override
	public List<Mecanicos> findAll() {
		return repository.findAll();
	}

	@Override
	public Mecanicos save(Mecanicos mecanicos) {
		return repository.save(mecanicos);
	}

	
	@Override
	public Mecanicos update(Mecanicos mecanicos) {
		Mecanicos mecanicosUpdate = new Mecanicos();
		mecanicosUpdate.setCiudad(mecanicos.getCiudad());
		mecanicosUpdate.setSalario(mecanicos.getSalario());
		mecanicosUpdate.setAparcamiento(mecanicos.getAparcamiento());
		return repository.save(mecanicosUpdate);
	}

	@Override
	public void delete(String dni) {
		repository.deleteById(dni);;
		
	}

	@Override
	public Optional<Mecanicos> findById(String dni) {
		return repository.findById(dni);
	}
	
	@Override
	public Mecanicos asociarPlazaMecanico(String dni, Aparcamiento aparcamiento) {
		Mecanicos mecanico = repository.findById(dni).get();
		mecanico.setAparcamiento(aparcamiento);
		return repository.save(mecanico);
	}

	@Override
	public List<Reparacion> findByMecanico_Dni(String dni) {
		return repository.findByMecanico_Dni(dni);
	}

}
