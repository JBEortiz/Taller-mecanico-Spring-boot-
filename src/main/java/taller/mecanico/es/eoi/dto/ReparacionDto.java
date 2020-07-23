package taller.mecanico.es.eoi.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReparacionDto {
	private Double precioReparacion;
	private Date fechaReparacion;
	private ReparacionesMecanicoDto mecanicos;
	private ReparacionesVehiculosDto vehiculos;
}
