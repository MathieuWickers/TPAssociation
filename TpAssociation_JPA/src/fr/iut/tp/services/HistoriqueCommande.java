package fr.iut.tp.services;

import java.util.ArrayList;
import java.util.List;

import fr.iut.tp.dao.*;
import fr.iut.tp.entities.*;

public class HistoriqueCommande {

	private CommandeDAO comDAO;

	public HistoriqueCommande() {
		comDAO = new CommandeDAO();
	}

	public List<ArrayList<Article>> getArticleByCommande(String loginAdherent) {
		List<ArrayList<Article>> allArticles = new ArrayList<ArrayList<Article>>();

		List<Commande> listCom = comDAO.listAll();
		for (Commande uneCom : listCom) {
			if (uneCom.getAdherent().getLogin()
					.compareToIgnoreCase(loginAdherent) == 0) {

				ArrayList<Article> artCommande = (ArrayList<Article>) uneCom
						.getArticles();
				allArticles.add(artCommande);
			}
		}
		return allArticles;
	}
	
	public List<Commande> getCommandeAdherent(String id) {
		List<Commande> commandes = new ArrayList<Commande>();
		List<Commande> adhCommandes = new ArrayList<Commande>();
		commandes = comDAO.listAll();
		for(Commande commande : commandes) {
			if (commande.getAdherent().getLogin().contentEquals(id)) {
				adhCommandes.add(commande);
			}
		}
		return adhCommandes;
	}

}
