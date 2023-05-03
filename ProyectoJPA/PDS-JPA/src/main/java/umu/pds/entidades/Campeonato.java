package umu.pds.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "campeonato")
public class Campeonato implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "fecha")
	private LocalDate fecha;

	@Column(name = "estado")
	private Boolean estado;

	// Campeonato relacion 1 a Muchos con Carrera
	@OneToMany(mappedBy = "campeonato", cascade = { CascadeType.ALL })
	private List<Carrera> carreras = new ArrayList<Carrera>();
	// Campeonato relacion 1 a Muchos con Tripulacion
	@OneToMany(mappedBy = "campeonato", cascade = { CascadeType.ALL })
	private List<Tripulacion> tripulaciones = new LinkedList<Tripulacion>();
	// Campeonato realcion 1 a Muchos con Equipo
	@OneToMany(mappedBy = "campeonato", cascade = { CascadeType.ALL })
	private List<Equipo> equipos = new LinkedList<Equipo>();

	// Constructores
	public Campeonato() {

	}

	public Campeonato(LocalDate fecha, Boolean estado) {
		this.fecha = fecha;
		this.estado = estado;
	}

	// Getters y Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public List<Carrera> getCarreras() {
		return carreras;
	}

	public void setCarreras(List<Carrera> carreras) {
		this.carreras = carreras;
	}

	public List<Tripulacion> getTripulaciones() {
		return tripulaciones;
	}

	public void setTripulaciones(List<Tripulacion> tripulaciones) {
		this.tripulaciones = tripulaciones;
	}

	public List<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	// ToString
	@Override
	public String toString() {
		return "Campeonato [id=" + id + ", fecha=" + fecha + ", estado=" + estado + "]";
	}

}
