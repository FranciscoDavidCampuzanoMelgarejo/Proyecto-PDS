package umu.pds.entidades;

import java.io.Serializable;
import java.util.LinkedList;
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
	private Integer id;

	@Column(name = "puntuacion")
	private Integer puntuacion;

	// Relacion Muchos a Uno con Campeonato
	@ManyToOne
	@JoinColumn(name = "id_campeonato")
	private Campeonato campeonato;
	// Relacion 1 a Muchos con Tripulacion
	@OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL)
	private List<Tripulacion> tripulaciones = new LinkedList<Tripulacion>();
	// Relacion 1 a 1 con Reserva
	@OneToOne
	@JoinColumn(name = "id_reserva")
	private Reserva reserva;

	public Equipo() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(Integer puntuacion) {
		this.puntuacion = puntuacion;
	}

	public List<Tripulacion> getTripulaciones() {
		return tripulaciones;
	}

	public void setTripulaciones(List<Tripulacion> tripulaciones) {
		this.tripulaciones = tripulaciones;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
