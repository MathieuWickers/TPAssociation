package org.licpro.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class logoutServlet
 */
@WebServlet(name = "LogoutServlet", urlPatterns = { "/logout", "/logout/*" })
public class logoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public logoutServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String nextPage = request.getPathInfo();
		if (nextPage.contentEquals("/deconnexion")) {

			request.getSession().invalidate();
			((HttpServletResponse) response).sendRedirect(request
					.getContextPath() + "/frontController");
		} else if (nextPage.contentEquals("/panier")) {
			request.getSession().removeAttribute("panier");
			((HttpServletResponse) response).sendRedirect(request
					.getContextPath() + "/frontController");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
