package umu.pds.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Tripulacion
 *
 */
@Entity
@Table(name = "tripulacion")
public class Tripulacion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "icono")
	private String icono;

	@Column(name = "email")
	private String email;

	@Column(name = "codigo_postal")
	private Integer codigoPostal;

	@Column(name = "fecha_registro")
	private LocalDate fechaRegistro;

	// 1 a Muchos Piloto
	// Muchos a 1 con Campeonato
	@ManyToOne
	@JoinColumn(name = "id_campeonato")
	private Campeonato campeonato;
	// Muchos a 1 con Equipo
	@ManyToOne
	@JoinColumn(name = "id_equipo")
	private Equipo equipo;
	// Uno a Muchos Participacion
	@OneToMany(mappedBy = "tripulacion", cascade = CascadeType.ALL)
	private List<Participacion> participaciones = new LinkedList<Participacion>();

	public Tripulacion() {
		super();
	}

	// Getters y Setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public List<Participacion> getParticipaciones() {
		return participaciones;
	}

	public void setParticipaciones(List<Participacion> participaciones) {
		this.participaciones = participaciones;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
