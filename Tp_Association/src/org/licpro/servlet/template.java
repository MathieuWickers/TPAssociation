package org.licpro.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class template
 */
@WebServlet("/template")
public class template extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Déclaration des jsp
	private static final String ERROR = "/jsp/404.jsp";
	private static final String INFO = "/jsp/info.jsp";
	private static final String ACCUEIL = "/jsp/accueil.jsp";
	private static final String INSCRIPTION = "/jsp/inscription.jsp";
	private static final String LOGIN = "/jsp/login.jsp";

	// Contient le nom de certaines jsp
	private static final List<String> existingPage = Arrays
			.asList("accueil", "info", "login", "inscription", "panier",
					"catalogue", "historique");

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public template() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		String identifiant = (String) request.getSession().getAttribute(
				"identifiant");
		if (identifiant != null) {
			rd = userIsLogin(request);
		} else {
			rd = userIsLogout(request);
		}
		rd.forward(request, response);
	}

	/**
	 * Affichage de la page web pour un utilisateur connecté
	 * 
	 * @param request
	 * @return
	 */
	protected RequestDispatcher userIsLogin(HttpServletRequest request) {
		RequestDispatcher rd = null;
		String page = (String) request.getAttribute("page");
		if (page == null || page.contentEquals("/")) {
			rd = getServletContext().getRequestDispatcher(ACCUEIL);
		} else {
			// Sinon on vérifie que le paramètre renvoie sur une page existante
			if (existingPage.contains(page)) {
				rd = getServletContext().getRequestDispatcher(
						"/jsp/" + page + ".jsp");
			} else {
				rd = getServletContext().getRequestDispatcher(ERROR);
			}
		}
		return rd;
	}

	/**
	 * Affichage de la page pour un utilisateur non connecté
	 * 
	 * @param request
	 * @return
	 */
	protected RequestDispatcher userIsLogout(HttpServletRequest request) {
		RequestDispatcher rd = null;
		String page = (String) request.getAttribute("page");
		if (page == null || page.contentEquals("/")) {
			rd = getServletContext().getRequestDispatcher(LOGIN);
		} else if (page.contentEquals("inscription")) {
			rd = getServletContext().getRequestDispatcher(INSCRIPTION);
		} else {
			// Sinon on vérifie que le paramètre renvoie sur une page existante
			if (existingPage.contains(page)) {
				rd = getServletContext().getRequestDispatcher(INFO);
			} else {
				rd = getServletContext().getRequestDispatcher(ERROR);
			}
		}
		return rd;
	}
}
