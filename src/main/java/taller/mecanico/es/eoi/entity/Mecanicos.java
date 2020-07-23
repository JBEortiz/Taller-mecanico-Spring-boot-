package taller.mecanico.es.eoi.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mecanicos")
public class Mecanicos implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String dni;
	@Column
	private String nombre;
	@Column
	private String ciudad;
	@Column
	private Double salario;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "repacion_id")
	private List<Reparacion> reparacion;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "mecanicos", cascade = CascadeType.ALL)
	private Aparcamiento aparcamiento;

	public Mecanicos() {
		super();
	}

	public Mecanicos(String dni, String nombre, String ciudad, Double salario, List<Reparacion> reparacion,
			Aparcamiento aparcamiento) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.salario = salario;
		this.reparacion = reparacion;
		this.aparcamiento = aparcamiento;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public List<Reparacion> getReparacion() {
		return reparacion;
	}

	public void setReparacion(List<Reparacion> reparacion) {
		this.reparacion = reparacion;
	}

	public Aparcamiento getAparcamiento() {
		return aparcamiento;
	}

	public void setAparcamiento(Aparcamiento aparcamiento) {
		this.aparcamiento = aparcamiento;
	}

}
