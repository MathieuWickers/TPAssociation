package fr.iut.tp.services;

import java.util.ArrayList;
import java.util.List;

import fr.iut.tp.dao.AdherentDAO;
import fr.iut.tp.dao.CommandeDAO;
import fr.iut.tp.entities.Adherent;
import fr.iut.tp.entities.Article;

public class CommandeService {
	private CommandeDAO commDao;
	private AdherentDAO adhDao;

	public CommandeService() {
		commDao = new CommandeDAO();
		adhDao = new AdherentDAO();
	}

	public Adherent findUserByLogin(String login) {
		List<Adherent> adherents = adhDao.listAll();
		for (Adherent adh : adherents) {
			if (adh.getLogin().contentEquals(login)) {
				return adh;
			}
		}
		return null;
	}

	public void creerCommande(int id, ArrayList<Article> articles, Adherent adh) {
		commDao.create(id, articles, adh);
	}
	
	public int getNumberCommande() {
		return commDao.listAll().size();
	}

}
