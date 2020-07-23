package taller.mecanico.es.eoi.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reparacion")
public class Reparacion implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private Double precioReparacion;

	@Column
	private Date fechaReparacion;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "dni")
	private Mecanicos mecanicos;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "matricula")
	private Vehiculos vehiculos;

	public Reparacion() {
		super();
	}

	public Reparacion(Double precioReparacion, Date fechaReparacion, Mecanicos mecanicos, Vehiculos vehiculos) {
		super();
		this.precioReparacion = precioReparacion;
		this.fechaReparacion = fechaReparacion;
		this.mecanicos = mecanicos;
		this.vehiculos = vehiculos;
	}

	public Double getPrecioReparacion() {
		return precioReparacion;
	}

	public void setPrecioReparacion(Double precioReparacion) {
		this.precioReparacion = precioReparacion;
	}

	public Date getFechaReparacion() {
		return fechaReparacion;
	}

	public void setFechaReparacion(Date fechaReparacion) {
		this.fechaReparacion = fechaReparacion;
	}

	public Mecanicos getMecanicos() {
		return mecanicos;
	}

	public void setMecanicos(Mecanicos mecanicos) {
		this.mecanicos = mecanicos;
	}

	public Vehiculos getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(Vehiculos vehiculos) {
		this.vehiculos = vehiculos;
	}

}
