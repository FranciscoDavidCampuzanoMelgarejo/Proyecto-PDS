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
	private Integer id;
	
	

	public CarreraFinal() {
		super();
	}
   
}
