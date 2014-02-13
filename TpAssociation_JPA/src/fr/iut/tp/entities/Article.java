package fr.iut.tp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ARTICLE", schema = "ROOT")
public class Article {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ARTICLE_ID")
	private int article_Id;

	@Column(name = "CODE")
	private String code;

	@Column(name = "NAME")
	private String nom;

	@Column(name = "PRICE")
	private double prix;
	
	@ManyToOne
	@JoinColumn(name="COMMANDE_ID")
	private Commande commande;

	public Article(int article_Id, String code, String nom, double prix,
			Commande commande) {
		super();
		this.article_Id = article_Id;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.commande = commande;
	}
	
	public Article(){
		super();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return article_Id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int article_Id) {
		this.article_Id = article_Id;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}

	/**
	 * @param prix
	 *            the prix to set
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}

}

