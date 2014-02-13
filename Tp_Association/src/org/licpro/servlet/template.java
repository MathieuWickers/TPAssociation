package org.licpro.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

	// Constante qui contient l'ensemble des pages existantes
	private static final List<String> existingPage = Arrays.asList("accueil",
			"info", "login");

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
		PrintWriter out = response.getWriter();
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public RequestDispatcher userIsLogin(HttpServletRequest request) {
		RequestDispatcher rd = null;
		String page = (String) request.getAttribute("page");
		if (page == null || page.contentEquals("/")) {
			rd = getServletContext().getRequestDispatcher("/jsp/accueil.jsp");
		} else {
			// Sinon on vérifie que le paramètre renvoie sur une page existante
			if (existingPage.contains(page)) {
				rd = getServletContext().getRequestDispatcher(
						"/jsp/" + page + ".jsp");
			} else {
				rd = getServletContext().getRequestDispatcher("/jsp/404.jsp");
			}
		}
		return rd;
	}

	public RequestDispatcher userIsLogout(HttpServletRequest request) {
		RequestDispatcher rd = null;
		String page = (String) request.getAttribute("page");
		if (page == null || page.contentEquals("/")) {
			rd = getServletContext().getRequestDispatcher("/jsp/login.jsp");
		} else {
			// Sinon on vérifie que le paramètre renvoie sur une page existante
			if (existingPage.contains(page)) {
				rd = getServletContext().getRequestDispatcher("/jsp/info.jsp");
			} else {
				rd = getServletContext().getRequestDispatcher("/jsp/404.jsp");
			}
		}
		return rd;
	}

}
