package fr.iut.tp.services;

import java.util.List;

import fr.iut.tp.dao.AdherentDAO;
import fr.iut.tp.entities.Adherent;

public class AuthentificationService {

	private AdherentDAO adhDAO;
	
	public AuthentificationService(){
		adhDAO = new AdherentDAO();
	}
	
	public Adherent findUserByLogin(String login){
		List<Adherent> adherents = adhDAO.listAll();
		for(Adherent adh : adherents){
			if (adh.getLogin().contentEquals(login)){
				return adh;
			}
		}
		return null;
	}
	
	public boolean authAdh(String login, String pwd){
		if (findUserByLogin(login)!=null){
			if(findUserByLogin(login).getPwd().equals(pwd)){
				return true;
			}
		}
		return false;
	}
}
