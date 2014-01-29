package org.licpro.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.licpro.entities.Adherent;

public class AdherentService {
	private EntityManager em = null;

	public AdherentService() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("jpa-tests");
		em = emf.createEntityManager();
	}

	/**
	 * Find an adherent by his id
	 * 
	 * @param id
	 * @return adherent
	 */
	public Adherent find(int id) {
		Adherent Adherent = em.find(Adherent.class, id);
		if (Adherent != null) {
			return Adherent;
		}
		return null;
	}

	public void delete(int id) {
		Adherent Adherent = find(id);
		if (null != Adherent) {
			em.remove(Adherent);
		}
	}

	public void delete(Adherent adherent) {
		Adherent Adherent = find(adherent.getId());
		if (null != Adherent) {
			em.remove(Adherent);
		}
	}

	public void create(Adherent Adherent) {
		final String QUERY = "INSERT INTO Adherent VALUES :id,:login,:mdp,:nomDeFamille,"
				+ ":prenom,:adresse,:codepostal,:ville,:pays";
		Query query = em.createQuery(QUERY);
		query.setParameter("id", Adherent.getId());
		query.setParameter("login", Adherent.getLogin());
		query.setParameter("mdp", Adherent.getMotDePasse());
		query.setParameter("nomDeFamille", Adherent.getNomDeFamille());
		query.setParameter("prenom", Adherent.getPrenom());
		query.setParameter("adresse", Adherent.getAdresse());
		query.setParameter("codepostal", Adherent.getCodePostal());
		query.setParameter("ville", Adherent.getVille());
		query.setParameter("pays", Adherent.getPays());
		this.em.getTransaction().begin();
		query.executeUpdate();
		em.getTransaction().commit();
	}

	public void update(Adherent Adherent) {
		String QUERY = "UPDATE Adherent Adherent SET Adherent.id = :id, Adherent.login = :login,"
				+ " Adherent.motDePasse = :mdp, Adherent.nomDeFamille = :ndf, "
				+ "Adherent.prenom = :prenom, Adherent.adresse = :adresse, "
				+ "Adherent.codePostal = :codepostal, Adherent.ville = :ville, "
				+ "Adherent.pays = :pays";
		Query query = em.createQuery(QUERY);
		query.setParameter("id", Adherent.getId());
		query.setParameter("login", Adherent.getLogin());
		query.setParameter("mdp", Adherent.getMotDePasse());
		query.setParameter("ndf", Adherent.getNomDeFamille());
		query.setParameter("prenom", Adherent.getPrenom());
		query.setParameter("adresse", Adherent.getAdresse());
		query.setParameter("codepostal", Adherent.getCodePostal());
		query.setParameter("ville", Adherent.getVille());
		query.setParameter("pays", Adherent.getPays());
		this.em.getTransaction().begin();
		query.executeUpdate();
		em.getTransaction().commit();
	}

	public List<Adherent> listAll() {
		Query query = em.createNamedQuery("SELECT * FROM Adherent");
		List<Adherent> Adherent = query.getResultList();
		return (Adherent);
	}
}
