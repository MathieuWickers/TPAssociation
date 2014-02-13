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
	
	public Article find(int id){
		Article art = em.find(Article.class, id);
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
	
	public void create(int article_Id, String code, String nom, double prix,
			Commande commande){
		em.getTransaction().begin();
		Article newArt= new Article(article_Id,code,nom,prix,commande);
        em.persist(newArt);
        em.getTransaction().commit();
	}
	
	public void delete(int ID){
		Article art = find(ID);
		em.getTransaction().begin();
		em.remove(art);
		em.getTransaction().commit();
	}
}
