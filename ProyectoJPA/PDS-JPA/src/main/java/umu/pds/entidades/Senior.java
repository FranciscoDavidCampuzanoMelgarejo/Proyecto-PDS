package umu.pds.entidades;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Senior
 *
 */
@Entity
@DiscriminatorValue("senior")
public class Senior extends Piloto {

	
	private static final long serialVersionUID = 1L;

	public Senior() {
		super();
	}
   
}
