package umu.pds.pruebas;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import umu.pds.entidades.Campeonato;
import umu.pds.entidades.Carrera;
import umu.pds.entidades.Participacion;

public class PruebaJPA {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadPersistencia");

	
	@Test
	public void crearCampeonato() {
		Campeonato campeonato = new Campeonato(LocalDate.now(), true);
		
		Carrera car1 = new Carrera();
		car1.setFecha(LocalDate.now());
		car1.setLocalizacion("Calle Inventada 1");
		car1.setNumMaxAsistentes(250);
		
		Carrera car2 = new Carrera();
		car2.setFecha(LocalDate.now());
		car2.setLocalizacion("Calle Inventada 2");
		car2.setNumMaxAsistentes(300);
		
		Carrera car3 = new Carrera();
		car3.setFecha(LocalDate.now());
		car3.setLocalizacion("Calle Inventada 3");
		car3.setNumMaxAsistentes(400);
		
		// Crear Participaciones
		Participacion p1 = new Participacion();
		p1.setFechaYHora(LocalDateTime.now());
		p1.setTiempo(620);
		p1.setPuntuacion(54);
		
		Participacion p2 = new Participacion();
		p2.setFechaYHora(LocalDateTime.now());
		p2.setTiempo(520);
		p2.setPuntuacion(71);
		
		campeonato.getCarreras().add(car1);
		campeonato.getCarreras().add(car2);
		campeonato.getCarreras().add(car3);
		car1.setCampeonato(campeonato);
		car2.setCampeonato(campeonato);
		car3.setCampeonato(campeonato);
		car1.getParticipaciones().add(p1);
		car2.getParticipaciones().add(p2);
		
		
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(campeonato);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			em.getTransaction().rollback();
		} finally {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			em.close();
		}
	}

}
