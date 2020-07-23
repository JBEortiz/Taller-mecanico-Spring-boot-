package taller.mecanico.es.eoi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import taller.mecanico.es.eoi.entity.Aparcamiento;
import taller.mecanico.es.eoi.repository.AparcamientoRepository;

@Service
public class AparcamientoServiceImpl implements AparcamientoService {

	@Autowired
	private AparcamientoRepository repository;

	@Override
	public List<Aparcamiento> findAll() {
		return repository.findAll();
	}

	@Override
	public Aparcamiento save(Aparcamiento aparcamiento) {
		return repository.save(aparcamiento);
	}

	@Override
	public Optional<Aparcamiento> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Aparcamiento update(Aparcamiento aparcamiento) {
		Aparcamiento aparcamientoUpdate = new Aparcamiento();
		aparcamientoUpdate.setColumna(aparcamiento.getColumna());
		aparcamientoUpdate.setFila(aparcamiento.getColumna());

		return repository.save(aparcamiento);
	}

	@Override
	public void delete(Aparcamiento aparcamiento) {
		repository.delete(aparcamiento);
	}

}
