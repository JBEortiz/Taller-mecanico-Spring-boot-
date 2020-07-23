package taller.mecanico.es.eoi.dto;

import lombok.Getter;
import lombok.Setter;
import taller.mecanico.es.eoi.entity.Aparcamiento;

@Getter
@Setter
public class MecanicosDto {
	private String dni;
	private String nombre;
	private String ciudad;
	private Double salario;
	private AparcamientoDto aparcamiento;

	
	

}