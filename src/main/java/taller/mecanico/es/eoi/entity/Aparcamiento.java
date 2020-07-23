package taller.mecanico.es.eoi.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "aparcamiento")
public class Aparcamiento implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String fila;
	private String columna;
	@OneToOne(fetch = FetchType.LAZY, optional=false)
	@JoinColumn(name = "mecanicos_id", referencedColumnName = "dni")
	private Mecanicos mecanicos;

	public Aparcamiento() {
		super();
	}

	public Aparcamiento(Long id, String fila, String columna, Mecanicos mecanicos) {
		super();
		this.id = id;
		this.fila = fila;
		this.columna = columna;
		this.mecanicos = mecanicos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFila() {
		return fila;
	}

	public void setFila(String fila) {
		this.fila = fila;
	}

	public String getColumna() {
		return columna;
	}

	public void setColumna(String columna) {
		this.columna = columna;
	}

	public Mecanicos getMecanicos() {
		return mecanicos;
	}

	public void setMecanicos(Mecanicos mecanicos) {
		this.mecanicos = mecanicos;
	}

}
