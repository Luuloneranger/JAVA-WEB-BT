package vn.iotstrar.contronller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Servlet implementation class HelloController
 */


@WebServlet(urlPatterns = ( "/home"))

public class HelloController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * response.setContentType("text/html"); response.setCharacterEncoding("UTF-8");
		 * request.setCharacterEncoding("UTF-8"); String ten =
		 * request.getParameter("ten"); String holot = request.getParameter("holot");
		 * PrintWriter out = response.getWriter(); out.println("<b>First Name</b>: " +
		 * ten + "<br/><b>Last Name</b>: "+ holot);
		 */
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String ten = request.getParameter("ten");
		String holot = request.getParameter("holot"); 
		PrintWriter out = response.getWriter();
		out.println("<b>First Name</b>: " + ten + "<br/><b>Last Name</b>: "+ holot);
		doGet(request, response);
	}

}
