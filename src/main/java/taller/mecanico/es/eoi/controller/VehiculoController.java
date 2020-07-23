package taller.mecanico.es.eoi.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.google.common.base.Optional;

import taller.mecanico.es.eoi.dto.VehiculosDto;
import taller.mecanico.es.eoi.entity.Vehiculos;
import taller.mecanico.es.eoi.service.VehiculoService;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {
	
	@Autowired
	private VehiculoService service;
	
	@GetMapping
	public ResponseEntity<?> findAllVehiculoss() {
		ModelMapper modelMapper = new ModelMapper();
		List<Vehiculos> VehiculosAll = (List<Vehiculos>) service.findAll();
		List<VehiculosDto> VehiculosDto = new ArrayList<VehiculosDto>();
		for (Vehiculos Vehiculos : VehiculosAll) {
			VehiculosDto.add(modelMapper.map(Vehiculos, VehiculosDto.class));
		}
		return new ResponseEntity<>(VehiculosDto, HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Vehiculos> createVehiculos(@RequestBody Vehiculos Vehiculos1) {
		Vehiculos Vehiculos = service.save( Vehiculos1);
		return ResponseEntity.status(HttpStatus.CREATED).body(Vehiculos);
	}
	
	@GetMapping("{matricula}")
	public ResponseEntity<VehiculosDto> getByNombreVehiculos(@PathVariable String matricula) {
		ModelMapper modelMapper = new ModelMapper();
		Vehiculos Vehiculos = service.findById(matricula).get();
		VehiculosDto VehiculosDto = new VehiculosDto();
		VehiculosDto = modelMapper.map(Vehiculos, VehiculosDto.class);
		return new ResponseEntity<VehiculosDto>(VehiculosDto, HttpStatus.OK);
	}
	@PutMapping("{matricula}")
	public ResponseEntity<?> update( @PathVariable String matricula,@RequestBody VehiculosDto Vehiculos1) {
		ModelMapper modelMapper = new ModelMapper(); 
		

		Vehiculos optional =service.findById(matricula).get();
		Vehiculos1= modelMapper.map(optional, VehiculosDto.class);
		if (optional == null) {
			return ResponseEntity.notFound().build();
		}
		Vehiculos componente1 = optional;
		componente1.setMatricula(Vehiculos1.getMatricula());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(componente1));

	}
	
	@DeleteMapping("{matricula}")
	public ResponseEntity<?> delete(@PathVariable String  matricula) {
		service.delete(matricula);
		return ResponseEntity.noContent().build();
	}
	

}
