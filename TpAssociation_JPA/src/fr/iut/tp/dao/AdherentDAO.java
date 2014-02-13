package fr.iut.tp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fr.iut.tp.entities.Adherent;

public class AdherentDAO {
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa");
	EntityManager em = factory.createEntityManager();
	
	public Adherent find(int id){
		Adherent adh = em.find(Adherent.class, id);
		if (adh !=null){
			return adh;
		}
		return null;	
	}
	
	public List<Adherent> listAll(){
		final String QUERY = "SELECT * FROM ADHERENT";
		Query query = em.createNativeQuery(QUERY, Adherent.class);
		List<Adherent> users = query.getResultList();
		return users;
	}
	
	public void create(int adherent_id, String login, String pwd, String prenom,
			String nom, String adress, int zip, String city, String country){
		em.getTransaction().begin();
		Adherent newAdh = new Adherent(adherent_id,login,pwd,prenom,nom,adress,zip,city,country);
        em.persist(newAdh);
        em.getTransaction().commit();
	}
	
	public void delete(int ID){
		Adherent adh = find(ID);
		em.getTransaction().begin();
		em.remove(adh);
		em.getTransaction().commit();
	}
}
