package umu.pds.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "carrera")
public class Carrera implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "localizacion")
	private String localizacion;

	@Column(name = "fecha")
	private LocalDate fecha;

	@Column(name = "max_asistentes")
	private Integer numMaxAsistentes;

	// Relacion Muchos a 1 con Campeoanto
	@ManyToOne
	@JoinColumn(name = "id_campeonato")
	private Campeonato campeonato;

	// Relacion 1 a Muchos con Participacion
	@OneToMany(mappedBy = "carrera", cascade = CascadeType.ALL)
	private List<Participacion> participaciones = new LinkedList<Participacion>();

	// Getters y Setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Integer getNumMaxAsistentes() {
		return numMaxAsistentes;
	}

	public void setNumMaxAsistentes(Integer numMaxAsistentes) {
		this.numMaxAsistentes = numMaxAsistentes;
	}

	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}

	public List<Participacion> getParticipaciones() {
		return participaciones;
	}

	public void setParticipaciones(List<Participacion> participaciones) {
		this.participaciones = participaciones;
	}

	// ToString
	@Override
	public String toString() {
		return "Carrera [id=" + id + ", localizacion=" + localizacion + ", fecha=" + fecha + ", numMaxAsistentes="
				+ numMaxAsistentes + ", getId()=" + getId() + ", getLocalizacion()=" + getLocalizacion()
				+ ", getFecha()=" + getFecha() + ", getNumMaxAsistentes()=" + getNumMaxAsistentes() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
