package taller.mecanico.es.eoi.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import taller.mecanico.es.eoi.dto.AparcamientoDto;
import taller.mecanico.es.eoi.entity.Aparcamiento;
import taller.mecanico.es.eoi.service.AparcamientoService;

@RestController
@RequestMapping("/parking")
public class AparcamientoController {

	@Autowired
	private AparcamientoService service;

	@GetMapping
	public ResponseEntity<?> findAllAparcamientos() {
		ModelMapper modelMapper = new ModelMapper();
		List<Aparcamiento> aparcamientoAll = service.findAll();
		List<AparcamientoDto> aparcamientoDto = new ArrayList<AparcamientoDto>();
		for (Aparcamiento Aparcamiento : aparcamientoAll) {
			aparcamientoDto.add(modelMapper.map(Aparcamiento, AparcamientoDto.class));
		}
		return new ResponseEntity<>(aparcamientoDto, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Aparcamiento> createAparcamiento(@RequestBody Aparcamiento aparcamiento1) {
		Aparcamiento aparcamiento = service.save(aparcamiento1);
		return ResponseEntity.status(HttpStatus.CREATED).body(aparcamiento);
	}

	@GetMapping("{id}")
	public ResponseEntity<AparcamientoDto> getByNombreAparcamiento(@PathVariable Long id) {
		ModelMapper modelMapper = new ModelMapper();
		Aparcamiento Aparcamiento = service.findById(id).get();
		AparcamientoDto aparcamientoDto = new AparcamientoDto();
		aparcamientoDto = modelMapper.map(Aparcamiento, AparcamientoDto.class);
		return new ResponseEntity<AparcamientoDto>(aparcamientoDto, HttpStatus.OK);
	}

}
