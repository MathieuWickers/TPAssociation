package fr.iut.tp.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(value=art_comPK.class)
@Table(name = "ART_COM", schema = "ROOT")
public class Art_com {
	
	@Id
	@Column(name="COMMANDE_ID", nullable=false)
	private int commande_id;
	
	@Id
	@Column(name="ARTICLE_CODE", nullable=false)
	private String article_code;

	
	public Art_com(int c_id, String art_code){
		this.commande_id = c_id;
		this.article_code = art_code;
	}
	
	public Art_com() {
		super();
	}
	
	
	/**
	 * @return the commande_id
	 */
	public int getCommande_id() {
		return commande_id;
	}

	/**
	 * @param commande_id the commande_id to set
	 */
	public void setCommande_id(int commande_id) {
		this.commande_id = commande_id;
	}

	/**
	 * @return the article_code
	 */
	public String getArticle_code() {
		return article_code;
	}

	/**
	 * @param article_code the article_code to set
	 */
	public void setArticle_code(String article_code) {
		this.article_code = article_code;
	}
	
	
	
	

}
