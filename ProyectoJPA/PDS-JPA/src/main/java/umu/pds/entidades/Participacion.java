package umu.pds.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Participacion
 *
 */
@Entity
@Table(name = "participacion")
public class Participacion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "fecha_hora")
	private LocalDateTime fechaYHora;

	@Column(name = "tiempo")
	private Integer tiempo;

	@Column(name = "puntuacion")
	private Integer puntuacion;

	@Column(name = "vuelta")
	private Integer vuelta;

	// Relacion Muchos a 1 con Carrera
	@ManyToOne
	@JoinColumn(name = "id_carrera")
	private Carrera carrera;
	// Relacion Muchos a 1 con Tripulacion
	@ManyToOne
	@JoinColumn(name = "id_tripulacion")
	private Tripulacion tripulacion;

	public Participacion() {
		super();
	}

	// Getters y Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFechaYHora() {
		return fechaYHora;
	}

	public void setFechaYHora(LocalDateTime fechaYHora) {
		this.fechaYHora = fechaYHora;
	}

	public Integer getTiempo() {
		return tiempo;
	}

	public void setTiempo(Integer tiempo) {
		this.tiempo = tiempo;
	}

	public Integer getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(Integer puntuacion) {
		this.puntuacion = puntuacion;
	}

	public Integer getVuelta() {
		return vuelta;
	}

	public void setVuelta(Integer vuelta) {
		this.vuelta = vuelta;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public Tripulacion getTripulacion() {
		return tripulacion;
	}

	public void setTripulacion(Tripulacion tripulacion) {
		this.tripulacion = tripulacion;
	}

	@Override
	public String toString() {
		return "Participacion [id=" + id + ", fechaYHora=" + fechaYHora + ", tiempo=" + tiempo + ", puntuacion="
				+ puntuacion + ", vuelta=" + vuelta + ", carrera=" + carrera + ", tripulacion=" + tripulacion + "]";
	}

}
