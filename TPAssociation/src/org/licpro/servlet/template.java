package org.licpro.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public template() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = (String) request.getAttribute("page");
		RequestDispatcher rd = null;
		PrintWriter out = response.getWriter();
		if(page.compareToIgnoreCase("login")==0){
			rd = getServletContext().getRequestDispatcher("/jsp/login.jsp");
		}else if(page.compareToIgnoreCase("accueil")==0){
					
			rd = getServletContext().getRequestDispatcher("/jsp/accueil.jsp");
		}else{
			rd = getServletContext().getRequestDispatcher("/jsp/404.jsp");
		}
		rd.forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
