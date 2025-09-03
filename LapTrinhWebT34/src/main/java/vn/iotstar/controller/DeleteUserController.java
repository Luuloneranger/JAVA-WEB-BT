package vn.iotstar.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import vn.iotstar.model.UserModel;
import vn.iotstar.service.*;

@WebServlet(urlPatterns = { "/delete" })
public class DeleteUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserService userS = new UserServiceImplement();
    public DeleteUserController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int username = Integer.parseInt(request.getParameter("id"));
		userS.delete(username);
		response.sendRedirect(request.getContextPath() + "/list");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
