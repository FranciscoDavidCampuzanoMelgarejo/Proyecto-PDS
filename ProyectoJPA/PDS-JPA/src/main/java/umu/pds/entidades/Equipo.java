package umu.pds.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Equipo
 *
 */
@Entity
@Table(name = "equipo")
public class Equipo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "puntuacion")
	private long puntuacion;

	// Relacion 1 a Muchos con Tripulacion
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_equipo")
	private List<Tripulacion> tripulaciones = new ArrayList<Tripulacion>(5);

	public Equipo() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(long puntuacion) {
		this.puntuacion = puntuacion;
	}

	public List<Tripulacion> getTripulaciones() {
		return tripulaciones;
	}

	public void setTripulaciones(List<Tripulacion> tripulaciones) {
		this.tripulaciones = tripulaciones;
	}

}
