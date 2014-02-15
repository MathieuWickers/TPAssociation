package fr.iut.tp.tests;

import java.util.List;

import fr.iut.tp.dao.AdherentDAO;
import fr.iut.tp.entities.Adherent;

;

public class AdherentTests {

	public static void main(String[] args) {

		AdherentDAO adhDAO = new AdherentDAO();

		// create new user
		adhDAO.create(2, "log", "pwd", "prenom", "nom", "adress", 44830,
				"nantes", "France");

		// find a user
		Adherent adh = adhDAO.find(2);
		System.out.println(adh.getLogin());

		// find all users
		List<Adherent> adherents = adhDAO.listAll();
		for (Adherent unAdh : adherents) {
			System.out.println(unAdh.getAdherent_id() + " " + unAdh.getLogin()
					+ " " + unAdh.getPwd() + " " + unAdh.getNom() + " "
					+ unAdh.getPrenom() + " " + unAdh.getAddress() + " "
					+ unAdh.getZip() + " " + unAdh.getCity() + " "
					+ unAdh.getCountry());
		}

		// delete user
		adhDAO.delete(2);

		// verif delete
		Adherent adhDelete = new Adherent();
		if (adhDAO.find(1) != null) {
			System.out.println(adhDelete.getLogin());
		} else {
			System.out.println("user not found");
		}
	}

}
