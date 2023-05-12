package umu.pds.entidades;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Reserva
 *
 */
@Entity
@Table(name = "reserva")
public class Reserva implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "fecha")
	private LocalDate fecha;

	@Column(name = "estado")
	@Enumerated(EnumType.STRING)
	private Estado estado;

	// Relacion unidireccional 1 a 1 con Equipo
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_equipo", referencedColumnName = "id")
	private Equipo equipo;

	public Reserva() {
		super();
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

}
