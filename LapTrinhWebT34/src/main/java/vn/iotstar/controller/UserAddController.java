package vn.iotstar.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import vn.iotstar.model.UserModel;
import vn.iotstar.service.*;
/**
 * Servlet implementation class UserAddController
 */
@WebServlet(urlPatterns = { "/add" })
public class UserAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	UserService userS = new UserServiceImplement();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAddController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("addUser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String fullname = request.getParameter("fullname");
        String password = request.getParameter("password");
        
        UserModel user = new UserModel();
        user.setUserName(username);
        user.setFullName(fullname);
        user.setPassWord(password);

        userS.insert(user);

        System.out.println(userS);
        
        response.sendRedirect(request.getContextPath() + "/list");
	}

}
