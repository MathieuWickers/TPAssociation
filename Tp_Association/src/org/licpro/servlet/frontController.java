package org.licpro.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String nextPage = null;

		// On garde cette partie pour tester mais à terme, il faut remplacer par
		// une vérification dans la BD
		if ("ok".contentEquals(pwd)) {
			request.getSession().setAttribute("identifiant", id);
			nextPage = "accueil";
		}

		// On affiche la page web
		request.setAttribute("page", nextPage);
		getServletContext().getRequestDispatcher("/template").forward(request,
				response);
	}

	protected void process(HttpServletRequest request,
			HttpServletResponse response) throws IOException {}
	
}
