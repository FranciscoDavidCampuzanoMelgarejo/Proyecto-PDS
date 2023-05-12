package umu.pds.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: CarreraFinal
 *
 */
@Entity
@Table(name = "carrera_final")
public class CarreraFinal implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	// Relacion Uno a Uno unidireccional con Piloto
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_piloto1", referencedColumnName = "id")
	private Piloto piloto1;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_piloto2", referencedColumnName = "id")
	private Piloto piloto2;

	public CarreraFinal() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
