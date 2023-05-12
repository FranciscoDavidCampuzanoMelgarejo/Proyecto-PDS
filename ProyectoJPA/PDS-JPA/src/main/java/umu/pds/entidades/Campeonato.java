package umu.pds.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "campeonato")
public class Campeonato implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "fecha")
	private LocalDate fecha;

	@Enumerated(EnumType.STRING)
	@Column(name = "estado")
	private Estado estado;

	// Campeonato relacion 1 a Muchos con Carrera
	@OneToMany(mappedBy = "campeonato", cascade = { CascadeType.ALL })
	private List<Carrera> carreras = new ArrayList<Carrera>();

	// Campeonato relacion 1 a Muchos con Tripulacion
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_campeonato")
	private List<Tripulacion> tripulaciones = new LinkedList<Tripulacion>();

	// Campeonato realcion 1 a Muchos con Equipo
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_campeonato")
	private List<Equipo> equipos = new LinkedList<Equipo>();

	// Relacion 1 a 1 con CarreraFinal
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_carrera_final", referencedColumnName = "id")
	private CarreraFinal carreraFinal;

	// Constructores
	public Campeonato() {

	}

	public Campeonato(LocalDate fecha, Estado estado) {
		this.fecha = fecha;
		this.estado = estado;
	}

	// Getters y Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
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

	public CarreraFinal getCarreraFinal() {
		return carreraFinal;
	}

	public void setCarreraFinal(CarreraFinal carreraFinal) {
		this.carreraFinal = carreraFinal;
	}

}
