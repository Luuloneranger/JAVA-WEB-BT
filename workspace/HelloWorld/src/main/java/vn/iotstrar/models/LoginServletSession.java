package vn.iotstrar.models;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServletSession
 */

@WebServlet (urlPatterns= ("/LoginS" ))
public class LoginServletSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServletSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String pass = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		if(username.equals("Luuloneranger")  && pass.equals("123") ) {
			/*out.print("Chào mừng bạn" + " " + username);*/
			HttpSession session = request.getSession();
			session.setAttribute("name", username);
			response.sendRedirect("/HelloWorld/Profile");
		}
		else {
			out.print("Tài khoản hoặc mật khẩu không chính xác");
			request.getRequestDispatcher("loginSession.html").include(request,response);
		}
		
		doGet(request, response);
	}

}
