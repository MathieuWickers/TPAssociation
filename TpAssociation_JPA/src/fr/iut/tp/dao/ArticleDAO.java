package fr.iut.tp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fr.iut.tp.entities.Article;
import fr.iut.tp.entities.Commande;

public class ArticleDAO {
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa");
	EntityManager em = factory.createEntityManager();
	
	public Article find(String code){
		Article art = em.find(Article.class, code);
		if (art !=null){
			return art;
		}
		return null;	
	}
	
	public List<Article> listAll(){
		final String QUERY = "SELECT * FROM ARTICLE";
		Query query = em.createNativeQuery(QUERY, Article.class);
		List<Article> articles = query.getResultList();
		return articles;
	}
	
	public Article create(String code, String nom, double prix,int stock){
		em.getTransaction().begin();
		Article newArt= new Article(code,nom,prix,stock);
        em.persist(newArt);
        em.getTransaction().commit();
        return newArt;
	}
	
	public void delete(String code){
		Article art = find(code);
		em.getTransaction().begin();
		em.remove(art);
		em.getTransaction().commit();
	}
}
