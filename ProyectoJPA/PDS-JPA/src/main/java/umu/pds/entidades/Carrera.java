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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "localizacion")
	private String localizacion;

	@Column(name = "fecha")
	private LocalDate fecha;

	@Column(name = "max_asistentes")
	private long numMaxAsistentes;

	// Relacion Muchos a 1 con Campeoanto
	@ManyToOne
	@JoinColumn(name = "id_campeonato")
	private Campeonato campeonato;

	// Relacion 1 a Muchos con Participacion
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_carrera")
	private List<Participacion> participaciones = new LinkedList<Participacion>();

	public Carrera() {

	}

	// Getters y Setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public long getNumMaxAsistentes() {
		return numMaxAsistentes;
	}

	public void setNumMaxAsistentes(long numMaxAsistentes) {
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

}
