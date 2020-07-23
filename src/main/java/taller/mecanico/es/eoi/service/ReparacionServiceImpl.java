package taller.mecanico.es.eoi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import taller.mecanico.es.eoi.entity.Reparacion;
import taller.mecanico.es.eoi.repository.MecanicoRepository;
import taller.mecanico.es.eoi.repository.RepacionRepository;
import taller.mecanico.es.eoi.repository.VehiculosRepository;
@Service
public class ReparacionServiceImpl implements ReparacionService{

	@Autowired
	private RepacionRepository repository;
	@Autowired
	private MecanicoRepository mRepository;
	@Autowired
	private VehiculosRepository vRepository;
	@Override
	public List<Reparacion> findAll() {
		return repository.findAll();
	}

	@Override
	public Reparacion save(Reparacion reparacion) {
		return repository.save(reparacion);
	}

	@Override
	public Optional<Reparacion> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Reparacion update(Reparacion reparacion) {
		Reparacion repacionPrice = new Reparacion();
		repacionPrice.setPrecioReparacion(reparacion.getPrecioReparacion());
		return repository.save(repacionPrice);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public List<Reparacion> findByMecanico_Dni(String dni) {
		return mRepository.findByMecanico_Dni(dni) ;
	}

	@Override
	public List<Reparacion> findByMatricula_Dni(String matricula) {
		return  vRepository.findByMatricula_Dni(matricula);
	}

}
