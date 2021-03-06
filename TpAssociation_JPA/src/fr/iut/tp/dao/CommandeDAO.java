package fr.iut.tp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fr.iut.tp.entities.Adherent;
import fr.iut.tp.entities.Art_com;
import fr.iut.tp.entities.Article;
import fr.iut.tp.entities.Commande;

public class CommandeDAO {
	private static EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("jpa");
	public EntityManager em = factory.createEntityManager();

	public Commande find(int id) {
		Commande com = em.find(Commande.class, id);
		if (com != null) {
			return com;
		}
		return null;
	}

	public List<Commande> listAll() {
		final String QUERY = "SELECT * FROM COMMANDE";
		Query query = em.createNativeQuery(QUERY, Commande.class);
		List<Commande> commandes = query.getResultList();
		return commandes;
	}

	public Commande create(int commande_id, List<Article> articles,
			Adherent adherent) {
		em.getTransaction().begin();
		Commande newCom = new Commande(commande_id, articles, adherent);
		em.persist(newCom);
		em.flush();
		for (Article art : articles) {
			Art_com art_com = new Art_com(commande_id, art.getCode());
			em.persist(art_com);
		}
		em.getTransaction().commit();
		return newCom;
	}

	public void delete(int ID) {
		Art_comDAO art_comDAO = new Art_comDAO();
		Commande com = find(ID);
		em.getTransaction().begin();
		em.remove(com);
		List<Art_com> list_artCom = new ArrayList<Art_com>();
		list_artCom = art_comDAO.listAll();
		for (Art_com art_com : list_artCom) {
			if (art_com.getCommande_id() == ID) {
				em.remove(art_com);
			}
		}
		em.getTransaction().commit();
	}
}
