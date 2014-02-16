package org.licpro.servlet;

import java.io.IOException;
import java.util.ArrayList;

import fr.iut.tp.entities.Adherent;
import fr.iut.tp.entities.Article;
import fr.iut.tp.services.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.iut.tp.services.AuthentificationService;
import fr.iut.tp.services.CommandeService;

/**
 * Servlet implementation class frontController
 */
@WebServlet(name = "frontController", urlPatterns = { "/frontController",
		"/frontController/*" })
public class frontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public frontController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String nextPage = request.getPathInfo();
		if (nextPage != null && !nextPage.contentEquals("/")) {
			if (nextPage.contentEquals("/article")) {
				ajoutArticleEnSession(request);
				request.getSession().setAttribute("handle", "succes");
				((HttpServletResponse) response).sendRedirect(request
						.getContextPath() + "/frontController/catalogue");
				return;
			} else if (!nextPage.contentEquals("/login")) {
				nextPage = nextPage.substring(1);
			} else {
				nextPage = "/";
			}
		}
		request.setAttribute("page", nextPage);
		getServletContext().getRequestDispatcher("/template").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String nextPage = request.getPathInfo();
		if (nextPage != null) {
			if (nextPage.substring(1).contentEquals("connexion")) {
				connexion(request);
			} else if (nextPage.substring(1).contentEquals("inscription")) {
				if (!inscription(request)) {
					request.setAttribute("page", "inscription");
				}
			} else if (nextPage.substring(1).contentEquals("commande")) {
				commande(request);
			}
		}

		getServletContext().getRequestDispatcher("/template").forward(request,
				response);
	}

	@SuppressWarnings("unchecked")
	/** 
	 * Ajoute un article en session
	 * @param request
	 */
	private void ajoutArticleEnSession(HttpServletRequest request) {
		// On récupère les paramètres de l'url
		String nom = (String) request.getParameter("nom");
		Double prix = Double.parseDouble(request.getParameter("prix"));
		String code = (String) request.getParameter("code");
		// On crée un nouvel article
		Article art = new Article();
		art.setCode(code);
		art.setNom(nom);
		art.setPrix(prix);
		ArrayList<Article> articles;
		// Si il n'ya pas encore de panier en session
		if (request.getSession().getAttribute("panier") == null) {
			// On rajoute un attribut panier
			articles = new ArrayList<Article>();
			request.getSession().setAttribute("panier", articles);
		}
		articles = (ArrayList<Article>) request.getSession().getAttribute(
				"panier");
		articles.add(art);
	}

	/**
	 * Vérifie que l'utilisateur est valide et si oui, lui crée une session
	 * 
	 * @param request
	 */
	private void connexion(HttpServletRequest request) {
		AuthentificationService as = new AuthentificationService();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		if (as.authAdh(id, pwd)) {
			request.getSession().setAttribute("identifiant", id);
		} else {
			request.getSession().setAttribute("handle", "error");
		}
	}

	/**
	 * Vérifie que le formulaire est bien rempli et crée un adhérent
	 * 
	 * @param request
	 */
	private boolean inscription(HttpServletRequest request) {
		if (verifChampObligatoire(request)) {
			if (verifLoginUnique(request)) {
				if (verifMdpIdentique(request)) {
					Adherent adh = creationAdherent(request);
					InscriptionService is = new InscriptionService();
					adh.setAdherent_id(is.getNumberAdherent() + 1);
					is.inscriptionAdherent(adh);
					String id = request.getParameter("id");
					request.getSession().setAttribute("identifiant", id);
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Vérifie que les champs obligatoires ne sont pas vide
	 * 
	 * @param request
	 * @return true si ok, false sinon
	 */
	private boolean verifChampObligatoire(HttpServletRequest request) {
		if (request.getParameter("id").contentEquals("")
				|| request.getParameter("pwd").contentEquals("")
				|| request.getParameter("pwdC").contentEquals("")
				|| request.getParameter("ndf").contentEquals("")
				|| request.getParameter("prenom").contentEquals("")) {
			request.getSession().setAttribute("handle", "oblig");
			return false;
		}
		return true;
	}

	/**
	 * Vérifie que le login de l'utilisateur est unique
	 * 
	 * @param request
	 * @return true si ok, false sinon
	 */
	private boolean verifLoginUnique(HttpServletRequest request) {
		InscriptionService is = new InscriptionService();
		String login = (String) request.getParameter("id");
		if (is.findUserByLogin(login) != null) {
			request.getSession().setAttribute("handle", "log");
			return false;
		}
		return true;
	}

	/**
	 * Vérifie que les deux mots de passe sont identiques
	 * 
	 * @param request
	 * @return true si ok, false sinon
	 */
	private boolean verifMdpIdentique(HttpServletRequest request) {
		if (request.getParameter("pwd").contentEquals(
				request.getParameter("pwdC"))) {
			return true;
		}
		request.getSession().setAttribute("handle", "mdp");
		return false;
	}

	/**
	 * Crée un adhérent
	 * 
	 * @param request
	 * @return l'adhérent crée
	 */
	private Adherent creationAdherent(HttpServletRequest request) {
		Adherent adh = new Adherent();
		adh.setLogin(request.getParameter("id"));
		adh.setPwd(request.getParameter("pwd"));
		adh.setNom(request.getParameter("ndf"));
		adh.setPrenom(request.getParameter("prenom"));

		String adresse = request.getParameter("adresse");
		if (!adresse.contentEquals("")) {
			adh.setAddress(adresse);
		}
		String codePostal = request.getParameter("codepostal");
		if (!codePostal.contentEquals("")) {
			adh.setZip(Integer.valueOf(codePostal));
		}
		String ville = request.getParameter("ville");
		if (!ville.contentEquals("")) {
			adh.setCity(ville);
		}
		String pays = request.getParameter("pays");
		if (!pays.contentEquals("")) {
			adh.setCountry(pays);
		}

		return adh;
	}

	/**
	 * Crée une commande et l'ajoute dans la base de données
	 * 
	 * @param request
	 */
	@SuppressWarnings("unchecked")
	private void commande(HttpServletRequest request) {
		ArrayList<Article> articles = (ArrayList<Article>) request.getSession()
				.getAttribute("panier");
		String id = (String) request.getSession().getAttribute("identifiant");
		CommandeService commServ = new CommandeService();
		Adherent adh = commServ.findUserByLogin(id);
		commServ.creerCommande(commServ.getNumberCommande(), articles, adh);
		request.getSession().removeAttribute("panier");
		request.getSession().setAttribute("handle", "commande");
	}

}
