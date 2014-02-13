package fr.iut.tp.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COMMANDE", schema = "ROOT")
public class Commande {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COMMANDE_ID")
	private int commande_Id;

	@OneToMany(mappedBy="commande")
	private List<Article> articles;
	
	@ManyToOne
	@JoinColumn(name="ADHERENT_ID")
	private Adherent adherent;
	
	public Commande(int commande_Id, List<Article> articles, Adherent adherent) {
		super();
		this.commande_Id = commande_Id;
		this.articles = articles;
		this.adherent = adherent;
	}
	
	public Commande(){
		super();
	}

	/**
	 * @return the id
	 */
	public int getCommande_Id() {
		return commande_Id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int commande_Id) {
		this.commande_Id = commande_Id;
	}

	/**
	 * @return the articles
	 */
	public List<Article> getArticles() {
		return articles;
	}

	/**
	 * @param articles
	 *            the articles to set
	 */
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

}
