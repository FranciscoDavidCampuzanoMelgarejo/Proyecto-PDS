package umu.pds.pruebas;

import static org.junit.Assert.*;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import umu.pds.entidades.Campeonato;
import umu.pds.entidades.Carrera;

public class PruebaJPA {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadPersistencia");

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void crearCampeonato() {
		Campeonato campeonato = new Campeonato(LocalDate.now(), true);
		
		Carrera car1 = new Carrera();
		car1.setFecha(LocalDate.now());
		car1.setLocalizacion("Calle Inventada 1");
		car1.setNumMaxAsistentes(250);
		
		Carrera car2 = new Carrera();
		car1.setFecha(LocalDate.of(2023, 1, 10));
		car1.setLocalizacion("Calle Inventada 2");
		car1.setNumMaxAsistentes(300);
		
		Carrera car3 = new Carrera();
		car1.setFecha(LocalDate.of(2022, 3, 15));
		car1.setLocalizacion("Calle Inventada 3");
		car1.setNumMaxAsistentes(400);
		
		campeonato.getCarreras().add(car1);
		campeonato.getCarreras().add(car2);
		campeonato.getCarreras().add(car3);
		car1.setCampeonato(campeonato);
		car2.setCampeonato(campeonato);
		car3.setCampeonato(campeonato);
		
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
