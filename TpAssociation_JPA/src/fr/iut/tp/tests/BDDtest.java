package fr.iut.tp.tests;

import java.util.ArrayList;
import java.util.List;

import fr.iut.tp.dao.AdherentDAO;
import fr.iut.tp.dao.ArticleDAO;
import fr.iut.tp.dao.CommandeDAO;
import fr.iut.tp.entities.Adherent;
import fr.iut.tp.entities.Article;
import fr.iut.tp.entities.Commande;

public class BDDtest {

	public static void main(String[] args) {
		AdherentDAO adhDAO = new AdherentDAO();
		CommandeDAO comDAO = new CommandeDAO();
		ArticleDAO artDAO = new ArticleDAO();
		
		Adherent leAdh = adhDAO.create(0, "log", "pwd", "prenom", "nom", "adress", 44830, "city", "country");
		Article leArt = artDAO.create("T_145","Tshirt vert",999.99,20);
		Article leArt2 = artDAO.create("T_146","Tshirt bleu",999.99,20);
		Article leArt3 = artDAO.create("T_147","Tshirt rouge",999.99,20);
		List<Article> laListArt = new ArrayList<Article>();
		List<Article> laListArt1 = new ArrayList<Article>();
		laListArt.add(leArt);
		laListArt.add(leArt2);
		Commande laCom = comDAO.create(0,laListArt, leAdh);
		laListArt1.add(leArt);
		laListArt1.add(leArt2);
		laListArt1.add(leArt3);
		Commande laCom1 = comDAO.create(1,laListArt1, leAdh);
		
		List<Commande> listCom = comDAO.listAll();
		for (Commande uneCom : listCom){
			if(uneCom.getAdherent().getAdherent_id()==0){
				System.out.println("Commande n°"+uneCom.getCommande_Id()+" venant de "+uneCom.getAdherent().getNom()+" "+uneCom.getAdherent().getPrenom());
				List<Article> artCommande = uneCom.getArticles();
				for(Article art : artCommande){
					System.out.println(art.getCode()+" "+art.getNom()+" "+art.getPrix());
				}
			}
		}
		
		/*Commande uneCom = comDAO.find(0); 
		System.out.println("Commande n°"+uneCom.getCommande_Id()+" venant de "+uneCom.getAdherent().getNom()+" "+uneCom.getAdherent().getPrenom());
		List<Article> artCommande = uneCom.getArticles();
		for(Article art : artCommande){
			System.out.println(art.getCode()+" "+art.getNom()+" "+art.getPrix());
		}*/
		
		comDAO.delete(0);
		comDAO.delete(1);
		artDAO.delete("T_145");
		artDAO.delete("T_146");
		artDAO.delete("T_147");
		adhDAO.delete(0);
		
	}

}
