package fr.iut.junit.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
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
public class TestCommandeDao {

	private static EntityManager em = null;
	private static CommandeDAO comDao = null;
	private static AdherentDAO adhDao = null;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpClass() throws Exception {
		comDao = new CommandeDAO();
		adhDao = new AdherentDAO();

		if (em == null) {
			em = comDao.em;
		}
	}

	// suppression de ce qui a �t� cr�e dans les tests
	@After
	public void tearDown() throws Exception {
		if (comDao.find(11) != null) {
			comDao.delete(11);
		}
		if (adhDao.find(333) != null) {
			adhDao.delete(333);
		}
		if (adhDao.find(222) != null) {
			adhDao.delete(222);
		}
		if (adhDao.find(555) != null) {
			adhDao.delete(555);
		}
	}

	@Test
	public void testFind() {

		Adherent adh = new Adherent(333, "logAdh1", "pwdAdh1", "The Dude",
				"iz back", "1 rue de paris", 111, "Paris", "France");
		em.persist(adh);

		ArrayList<Article> arrArts = new ArrayList<Article>();
		Commande comTest = new Commande(11, arrArts, adh);

		Article art1 = new Article("pny", "paunay", 987, 12);
		Article art2 = new Article("ak", "ak-47", 123, 10);
		arrArts.add(art1);
		arrArts.add(art2);
		comTest.setArticles(arrArts);

		em.getTransaction().begin();

		em.persist(comTest);

		Query query = em
				.createQuery("Select com from Commande com where com.commande_Id=:commande_Id");
		query.setParameter("commande_Id", comTest.getCommande_Id());
		Commande comRes = (Commande) query.getSingleResult();

		Commande comResByFind = comDao.find(comTest.getCommande_Id());

		assertEquals(comResByFind, comRes);

		em.remove(comTest);
		em.getTransaction().commit();
	}

	@Test
	public void testCreate() {

		Adherent adh = new Adherent(222, "logAdh1", "pwdAdh1", "The Dude",
				"iz back", "1 rue de paris", 111, "Paris", "France");
		em.persist(adh);

		ArrayList<Article> arrArts = new ArrayList<Article>();
		Commande comTest = new Commande(11, arrArts, adh);

		Article art1 = new Article("pny", "paunay", 987, 12);
		Article art2 = new Article("ak", "ak-47", 123, 10);
		arrArts.add(art1);
		arrArts.add(art2);
		comTest.setArticles(arrArts);

		comDao.create(comTest.getCommande_Id(), comTest.getArticles(),
				comTest.getAdherent());

		em.getTransaction().begin();

		Query query = em
				.createQuery("Select com from Commande com where com.commande_Id=:commande_Id");
		query.setParameter("commande_Id", comTest.getCommande_Id());
		Commande comRes = (Commande) query.getSingleResult();

		assertEquals(comTest.getCommande_Id(), comRes.getCommande_Id());
		assertEquals(comTest.getAdherent(), comRes.getAdherent());

		em.getTransaction().commit();
	}

	@Test
	public void testDelete() {

		Adherent adh = new Adherent(555, "logAdh1", "pwdAdh1", "The Dude",
				"iz back", "1 rue de paris", 111, "Paris", "France");
		em.persist(adh);

		ArrayList<Article> arrArts = new ArrayList<Article>();
		Commande comTest = new Commande(11, arrArts, adh);

		Article art1 = new Article("pny", "paunay", 987, 12);
		Article art2 = new Article("ak", "ak-47", 123, 10);
		arrArts.add(art1);
		arrArts.add(art2);
		comTest.setArticles(arrArts);

		// le test du create passe, donc on peut l'utiliser ici
		comDao.create(comTest.getCommande_Id(), comTest.getArticles(),
				comTest.getAdherent());

		em.getTransaction().begin();

		// on v�rifie que l'objet est bien pr�sent dans la bd
		Query query = em
				.createQuery("Select com from Commande com where com.commande_Id=:commande_Id");
		query.setParameter("commande_Id", comTest.getCommande_Id());
		Commande comRes = (Commande) query.getSingleResult();

		assertSame(comTest.getCommande_Id(), comRes.getCommande_Id());

		em.getTransaction().commit();

		comDao.delete(comTest.getCommande_Id());

		// on v�rifie maintenant que l'objet a bien �t� supprim�
		em.getTransaction().begin();
		query = em
				.createQuery("Select com from Commande com where com.commande_Id=:commande_Id");
		query.setParameter("commande_Id", comTest.getCommande_Id());

		comRes = null;

		if (!query.getResultList().isEmpty()) {
			comRes = (Commande) query.getSingleResult();
		}
		assertNull(comRes);

		em.getTransaction().commit();
	}
}
