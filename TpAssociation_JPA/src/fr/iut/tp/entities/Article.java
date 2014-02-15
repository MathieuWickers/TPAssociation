package fr.iut.tp.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ARTICLE", schema = "ROOT")
public class Article {

	@Id
	@Column(name = "ARTICLE_CODE")
	private String code;

	@Column(name = "NAME")
	private String nom;

	@Column(name = "PRICE")
	private double prix;
	
	@Column(name = "STOCK")
	private int stock;
	
	@ManyToMany 
	@JoinTable( name="ART_COM", 
			 joinColumns={@JoinColumn(name="ARTICLE_CODE", referencedColumnName="ARTICLE_CODE")},
		      inverseJoinColumns={@JoinColumn(name="COMMANDE_ID", referencedColumnName="COMMANDE_ID")})
	private List<Commande> commandes;
	
	public Article(String code, String nom, double prix,int stock) {
		super();
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.stock = stock;
	}
	
	public Article(){
		super();
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

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommande(List<Commande> commandes) {
		this.commandes = commandes;
	}

}

