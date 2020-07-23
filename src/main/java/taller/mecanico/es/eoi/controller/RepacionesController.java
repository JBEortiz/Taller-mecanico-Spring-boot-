package taller.mecanico.es.eoi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import taller.mecanico.es.eoi.dto.ReparacionDto;
import taller.mecanico.es.eoi.entity.Mecanicos;
import taller.mecanico.es.eoi.entity.Reparacion;
import taller.mecanico.es.eoi.entity.Vehiculos;
import taller.mecanico.es.eoi.service.MecanicoService;
import taller.mecanico.es.eoi.service.ReparacionService;
import taller.mecanico.es.eoi.service.VehiculoService;

@RestController
@RequestMapping("/repacion")
public class RepacionesController {

	@Autowired
	private ReparacionService service;
	@Autowired
	private VehiculoService vService;
	@Autowired
	private MecanicoService mService;

	@GetMapping
	public ResponseEntity<?> findAll() {
		ModelMapper modelMapper = new ModelMapper();
		List<Reparacion> ReparacionAll = service.findAll();
		List<ReparacionDto> ReparacionDto = new ArrayList<ReparacionDto>();
		for (Reparacion Reparacion : ReparacionAll) {
			ReparacionDto.add(modelMapper.map(Reparacion, ReparacionDto.class));
		}
		return new ResponseEntity<>(ReparacionAll, HttpStatus.OK);
	}

	@GetMapping("/vehiculo/{matricula}")
	public ResponseEntity<?> getByMatriculaReparacion(@PathVariable String matricula) {
		List<Reparacion> ReparacionAll = service.findAll();
		List<Reparacion> newListR = new ArrayList<Reparacion>();
		for (Reparacion Reparacion : ReparacionAll) {
			if (Reparacion.getVehiculos().getMatricula().equals(matricula)) {
				newListR.add(Reparacion);
			}
		}
		return new ResponseEntity<List<Reparacion>>(newListR, HttpStatus.OK);

	}

	@GetMapping("/mecanico/{dni}")
	public ResponseEntity<List<Reparacion>> getByDniReparacion(@PathVariable String dni) {
		List<Reparacion> ReparacionAll = service.findAll();
		List<Reparacion> newListR = new ArrayList<Reparacion>();
		for (Reparacion Reparacion : ReparacionAll) {
			if (Reparacion.getVehiculos().getMatricula().equals(matricula)) {
				newListR.add(Reparacion);
			}
		}
		return new ResponseEntity<List<Reparacion>>(newListR, HttpStatus.OK);

	}
//	

	@PostMapping
	public ResponseEntity<Map<String, Object>> createReparacions(@RequestBody ReparacionDto rDto) {
		Map<String, Object> response = new HashMap<String, Object>();
		ModelMapper modelMapper = new ModelMapper();
		Mecanicos mecanico = mService.findById(rDto.getMecanicos().getDni()).get();
		Vehiculos vehiculo = vService.findById(rDto.getVehiculos().getMatricula()).get();
		Reparacion reparacion = modelMapper.map(rDto, Reparacion.class);
		reparacion.setMecanicos(mecanico);
		reparacion.setVehiculos(vehiculo);
		Reparacion newReparacion = service.save(reparacion);
		response.put("Reparacion creado", newReparacion);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ReparacionDto> getByNombreReparacion(@PathVariable Long id) {
		ModelMapper modelMapper = new ModelMapper();
		Reparacion Reparacion = service.findById(id).get();
		ReparacionDto ReparacionDto = new ReparacionDto();
		ReparacionDto = modelMapper.map(Reparacion, ReparacionDto.class);
		return new ResponseEntity<ReparacionDto>(ReparacionDto, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Reparacion> updateRepacionPrice(@RequestBody ReparacionDto rDto, @PathVariable Long id) {
		ModelMapper modelMapper = new ModelMapper();
		Reparacion repatacionUpdate = service.findById(id).get();
		rDto = modelMapper.map(repatacionUpdate, ReparacionDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(service.update(repatacionUpdate));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
