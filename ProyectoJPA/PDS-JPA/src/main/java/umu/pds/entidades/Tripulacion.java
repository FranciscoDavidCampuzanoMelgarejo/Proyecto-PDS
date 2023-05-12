package umu.pds.entidades;

import java.io.Serializable;
import java.time.LocalDate;

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
	private long id;

	@Column(name = "icono")
	private String icono;

	@Column(name = "email")
	private String email;

	@Column(name = "codigo_postal")
	private Integer codigoPostal;

	@Column(name = "fecha_registro")
	private LocalDate fechaRegistro;

	// 1 a Muchos Piloto

	// Relacion Uno a Uno bidireccional con Participacion
	@OneToOne(mappedBy = "tripulacion", cascade = CascadeType.ALL)
	private Participacion participacion;

	// Relacion Uno a Uno unidireccional con Piloto
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_piloto1", referencedColumnName = "id")
	private Piloto piloto1;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_piloto2", referencedColumnName = "id")
	private Piloto piloto2;

	public Tripulacion() {
		super();
	}

	// Getters y Setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public Participacion getParticipacion() {
		return participacion;
	}

	public void setParticipacion(Participacion participacion) {
		this.participacion = participacion;
	}

	public Piloto getPiloto1() {
		return piloto1;
	}

	public void setPiloto1(Piloto piloto1) {
		this.piloto1 = piloto1;
	}

	public Piloto getPiloto2() {
		return piloto2;
	}

	public void setPiloto2(Piloto piloto2) {
		this.piloto2 = piloto2;
	}

}
