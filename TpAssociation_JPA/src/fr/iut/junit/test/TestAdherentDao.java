package fr.iut.junit.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import fr.iut.tp.dao.*;
import fr.iut.tp.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * @author kl
 * 
 */
public class TestAdherentDao {

	private static EntityManager em = null;
	private static AdherentDAO adhDao = null;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpClass() throws Exception {
		adhDao = new AdherentDAO();

		if (em == null) {

			em = adhDao.em;
		}
	}

	@Test
	public void testFind() {
		// Start a transaction
		Adherent adhTest = new Adherent(6, "logAdh1", "pwdAdh1", "The Dude",
				"iz back", "1 rue de paris", 111, "Paris", "France");

		adhDao.create(adhTest);

		em.getTransaction().begin();
		Query query = em
				.createQuery("Select adh from Adherent adh where adh.adherent_id=:adherent_id");
		query.setParameter("adherent_id", adhTest.getAdherent_id());
		Adherent adhRes = (Adherent) query.getSingleResult();

		Adherent adhResByFind = adhDao.find(adhTest.getAdherent_id());
		assertSame(adhResByFind, adhRes);
		em.remove(adhTest);
		em.getTransaction().commit();
	}

	@Test
	public void testCreate1() {
		// Start a transaction

		Adherent adhTest = new Adherent(6, "logAdh1", "pwdAdh1", "The Dude",
				"iz back", "1 rue de paris", 111, "Paris", "France");

		adhDao.create(adhTest);
		em.getTransaction().begin();
		Query query = em
				.createQuery("Select adh from Adherent adh where adh.adherent_id=:adherent_id");
		query.setParameter("adherent_id", adhTest.getAdherent_id());
		Adherent adhRes = (Adherent) query.getSingleResult();
		assertSame(adhTest, adhRes);

		em.remove(adhTest);

		em.getTransaction().commit();
	}

	@Test
	public void testCreate2() {
		// Start a transaction
		Adherent adhTest = new Adherent(81, "logAdh2", "pwdAdh2", "The Dude",
				"iz not back", "2 rue de paris", 222, "Paris", "France");

		adhDao.create(adhTest.getAdherent_id(), adhTest.getLogin(),
				adhTest.getPwd(), adhTest.getPrenom(), adhTest.getNom(),
				adhTest.getAddress(), adhTest.getZip(), adhTest.getCity(),
				adhTest.getCountry());

		em.getTransaction().begin();
		Query query = em
				.createQuery("Select adh from Adherent adh where adh.adherent_id=:adherent_id");
		query.setParameter("adherent_id", adhTest.getAdherent_id());
		Adherent adhRes = (Adherent) query.getSingleResult();

		assertSame(adhTest.getAdherent_id(), adhRes.getAdherent_id());
		assertSame(adhTest.getLogin(), adhRes.getLogin());
		assertSame(adhTest.getPwd(), adhRes.getPwd());

		em.getTransaction().commit();

		em.remove(adhRes);
	}

	@Test
	public void testDelete() {
		// Start a transaction

		Adherent adhTest = new Adherent(71, "logAdh1", "pwdAdh1", "The Dude",
				"iz back", "1 rue de paris", 111, "Paris", "France");

		adhDao.create(adhTest);
		em.getTransaction().begin();
		Query query = em
				.createQuery("Select adh from Adherent adh where adh.adherent_id=:adherent_id");
		query.setParameter("adherent_id", adhTest.getAdherent_id());
		Adherent adhRes = (Adherent) query.getSingleResult();
		assertSame(adhTest, adhRes);
		em.getTransaction().commit();
		adhDao.delete(adhTest.getAdherent_id());
		em.getTransaction().begin();
		query = em
				.createQuery("Select adh from Adherent adh where adh.adherent_id=:adherent_id");
		query.setParameter("adherent_id", adhTest.getAdherent_id());
		adhRes = null;
		if (!query.getResultList().isEmpty()) {
			adhRes = (Adherent) query.getSingleResult();
		}
		assertNull(adhRes);

		em.getTransaction().commit();
	}

}
