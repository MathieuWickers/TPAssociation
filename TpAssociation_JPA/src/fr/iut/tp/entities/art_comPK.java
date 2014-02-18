package fr.iut.tp.entities;

import java.io.Serializable;

public class art_comPK implements Serializable {
	private int commande_id;
	private String article_code;

	public art_comPK() {

	}

	/**
	 * @return the commande_id
	 */
	public int getCommande_id() {
		return commande_id;
	}

	/**
	 * @param commande_id
	 *            the commande_id to set
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
	 * @param article_code
	 *            the article_code to set
	 */
	public void setArticle_code(String article_code) {
		this.article_code = article_code;
	}

	public int hashCode() {
		return article_code.hashCode() + commande_id;
	}

	public boolean equals(Object obj) {
		if (obj instanceof art_comPK) {
			art_comPK artPk = (art_comPK) obj;

			if (!artPk.getArticle_code().equals(this.article_code)) {
				return false;
			}
			if (artPk.getCommande_id() != this.commande_id) {
				return false;
			}
			return true;
		}
		return false;
	}

}
