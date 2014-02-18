package fr.iut.tp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fr.iut.tp.entities.Art_com;

public class Art_comDAO {
	private static EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("jpa");
	public EntityManager em = factory.createEntityManager();

	public List<Art_com> listAll() {
		final String QUERY = "SELECT * FROM ART_COM";
		Query query = em.createNativeQuery(QUERY, Art_com.class);
		List<Art_com> list_artCom = query.getResultList();
		return list_artCom;
	}

}
