package taller.mecanico.es.eoi.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vehiculos")
public class Vehiculos implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String matricula;
	@Column
	private String marca;
	@Column
	private String modelo;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "repacion_id")
	private List<Reparacion> reparacion;

	public Vehiculos() {
		super();
	}

	public Vehiculos(String matricula, String marca, String modelo, List<Reparacion> reparacion) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.reparacion = reparacion;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public List<Reparacion> getReparacion() {
		return reparacion;
	}

	public void setReparacion(List<Reparacion> reparacion) {
		this.reparacion = reparacion;
	}

}
