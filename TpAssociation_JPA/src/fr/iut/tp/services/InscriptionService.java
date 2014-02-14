package fr.iut.tp.services;

import java.util.List;

import fr.iut.tp.dao.AdherentDAO;
import fr.iut.tp.entities.Adherent;

public class InscriptionService {
	private AdherentDAO adhDAO;

	public InscriptionService() {
		adhDAO = new AdherentDAO();
	}

	public Adherent findUserByLogin(String login) {
		List<Adherent> adherents = adhDAO.listAll();
		for (Adherent adh : adherents) {
			if (adh.getLogin().equals(login)) {
				return adh;
			}
		}
		return null;
	}
	
	public int getNumberAdherent() {
		return adhDAO.listAll().size();
	}
	
	public void inscriptionAdherent(Adherent adh) {
		adhDAO.create(adh);
	}
}
