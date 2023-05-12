package umu.pds.entidades;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("junior")
public class Junior extends Piloto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Junior() {
		super();
	}

}
