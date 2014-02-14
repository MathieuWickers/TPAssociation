package org.licpro.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import fr.iut.tp.entities.Adherent;
import fr.iut.tp.services.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		PrintWriter out = response.getWriter();
		String nextPage = request.getPathInfo();
		if (nextPage != null && !nextPage.contentEquals("/")) {
			if (!nextPage.contentEquals("/login")) {
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
				inscription(request);
			}
		}

		getServletContext().getRequestDispatcher("/template").forward(request,
				response);
	}

	protected void process(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
	}

	public void connexion(HttpServletRequest request) {
		AuthentificationService as = new AuthentificationService();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		if (as.authAdh(id, pwd)) {
			request.getSession().setAttribute("identifiant", id);
		}
	}

	private void inscription(HttpServletRequest request) {
		if (verifChampObligatoire(request)) {
			if (verifLoginUnique(request)) {
				if (verifMdpIdentique(request)) {
					Adherent adh = creationAdherent(request);
					InscriptionService is = new InscriptionService();
					adh.setAdherent_id(is.getNumberAdherent());
					is.inscriptionAdherent(adh);
				}
			}
		}
	}

	private boolean verifChampObligatoire(HttpServletRequest request) {
		if (request.getParameter("id").contentEquals("")
				|| request.getParameter("pwd").contentEquals("")
				|| request.getParameter("pwdC").contentEquals("")
				|| request.getParameter("ndf").contentEquals("")
				|| request.getParameter("prenom").contentEquals("")) {
			return false;
		}
		return true;
	}

	private boolean verifLoginUnique(HttpServletRequest request) {
		InscriptionService is = new InscriptionService();
		String login = (String) request.getAttribute("id");
		if (is.findUserByLogin(login) != null) {
			return false;
		}
		return true;
	}

	private boolean verifMdpIdentique(HttpServletRequest request) {
		if (request.getParameter("pwd").contentEquals(
				request.getParameter("pwdC"))) {
			return true;
		}
		return false;
	}

	private Adherent creationAdherent(HttpServletRequest request) {
		Adherent adh = new Adherent();
		String id = request.getParameter("id");
		adh.setLogin(id);
		String pwd = request.getParameter("pwd");
		adh.setPwd(pwd);
		String ndf = request.getParameter("ndf");
		adh.setNom(ndf);
		String prenom = request.getParameter("prenom");
		adh.setPrenom(prenom);

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

}
