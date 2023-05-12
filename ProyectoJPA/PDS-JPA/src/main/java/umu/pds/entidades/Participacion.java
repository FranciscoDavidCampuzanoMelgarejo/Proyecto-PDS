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
	private long id;

	@Column(name = "fecha_hora")
	private LocalDateTime fechaYHora;

	@Column(name = "tiempo")
	private long tiempo;

	@Column(name = "puntuacion")
	private long puntuacion;


	
	// Relacion 1 a 1 con Tripulacion
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_tripulacion", referencedColumnName = "id")
	private Tripulacion tripulacion;

	public Participacion() {
		super();
	}

	// Getters y Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getFechaYHora() {
		return fechaYHora;
	}

	public void setFechaYHora(LocalDateTime fechaYHora) {
		this.fechaYHora = fechaYHora;
	}

	public long getTiempo() {
		return tiempo;
	}

	public void setTiempo(long tiempo) {
		this.tiempo = tiempo;
	}

	public long getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(long puntuacion) {
		this.puntuacion = puntuacion;
	}


	public Tripulacion getTripulacion() {
		return tripulacion;
	}

	public void setTripulacion(Tripulacion tripulacion) {
		this.tripulacion = tripulacion;
	}

}
