package taller.mecanico.es.eoi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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

import taller.mecanico.es.eoi.dto.AparcamientoDto;
import taller.mecanico.es.eoi.dto.MecanicosDto;
import taller.mecanico.es.eoi.entity.Aparcamiento;
import taller.mecanico.es.eoi.entity.Mecanicos;
import taller.mecanico.es.eoi.service.AparcamientoService;
import taller.mecanico.es.eoi.service.MecanicoService;

@RestController
@RequestMapping("/mecanico")
public class MecanicoController {
	@Autowired
	private MecanicoService service;
	@Autowired
	private AparcamientoService aparcamientoService;
	
	@GetMapping
	public ResponseEntity<?> findAllMecanicoss() {
		ModelMapper modelMapper = new ModelMapper();
		List<Mecanicos> MecanicosAll = (List<Mecanicos>) service.findAll();
		List<MecanicosDto> MecanicosDto = new ArrayList<MecanicosDto>();
		for (Mecanicos Mecanicos : MecanicosAll) {
			MecanicosDto.add(modelMapper.map(Mecanicos, MecanicosDto.class));
		}
		return new ResponseEntity<>(MecanicosDto, HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Map<String, Object>> createMecanicos(@RequestBody MecanicosDto mecanicos1) {
		Map<String, Object> response = new HashMap<String, Object>();
		ModelMapper modelMapper = new ModelMapper();
		Aparcamiento parking= aparcamientoService.findById(mecanicos1.getAparcamiento().getId()).get();
		Mecanicos mecanico = modelMapper.map(mecanicos1, Mecanicos.class);
		mecanico.setAparcamiento(parking);
		Mecanicos newMecanico= null;
		  try {
	            newMecanico = service.save(mecanico);
	        } catch (DataAccessException e) {
	            response.put("message", "Error al insertar en la base de datos");
	            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
	            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	        response.put("newMecanico", newMecanico);
	        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	    }
	
	
	@PostMapping("/{dni}/plaza/1")
    public ResponseEntity<Map<String,Object>> assignParking(@PathVariable String dni, @RequestBody AparcamientoDto parking) {
        Map<String,Object> response = new HashMap<String, Object>();
        ModelMapper modelMapper = new ModelMapper();

        Aparcamiento newParking = aparcamientoService.findById(parking.getId()).get();
        Mecanicos myMecanico = service.asociarPlazaMecanico(dni, newParking);

        response.put("mecanico Updated", modelMapper.map(myMecanico, MecanicosDto.class));
        return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);
    }
	
	
	// PRIMERA FORMA SIN TOCAR EL SERVICE
	@PostMapping("/{dni}/plaza")
    public ResponseEntity<Map<String,Object>> assignParking1(@PathVariable String dni, @RequestBody AparcamientoDto parking) {
        Map<String,Object> response = new HashMap<String, Object>();
        ModelMapper modelMapper = new ModelMapper();

        Mecanicos myMecanico = service.findById(dni).get();
        Aparcamiento newParking = aparcamientoService.findById(parking.getId()).get();

        myMecanico.setAparcamiento(newParking);
        service.save(myMecanico);
        response.put("mecanico Updated", modelMapper.map(myMecanico, MecanicosDto.class));
        return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);
    }
	
	
	@GetMapping("{dni}")
	public ResponseEntity<MecanicosDto> getByNombreMecanicos(@PathVariable String dni) {
		ModelMapper modelMapper = new ModelMapper();
		Mecanicos Mecanicos = service.findById(dni).get();
		MecanicosDto MecanicosDto = new MecanicosDto();
		MecanicosDto = modelMapper.map(Mecanicos, MecanicosDto.class);
		return new ResponseEntity<MecanicosDto>(MecanicosDto, HttpStatus.OK);
	}
	
	@PutMapping("{dni}")
	public ResponseEntity<?> update(@RequestBody MecanicosDto mecanicos1, @PathVariable String dni) {
		ModelMapper modelMapper = new ModelMapper(); 
		Mecanicos mecanicos = service.findById(dni).get();
		mecanicos1= modelMapper.map(mecanicos, MecanicosDto.class);

		return ResponseEntity.status(HttpStatus.CREATED).body(service.update(mecanicos));

	}
	
	@DeleteMapping("{dni}")
	public ResponseEntity<?> delete(@PathVariable String  dni) {
		service.delete(dni);
		return ResponseEntity.noContent().build();
	}
}
