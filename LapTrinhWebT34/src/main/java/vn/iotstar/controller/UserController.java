package vn.iotstar.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import vn.iotstar.model.UserModel;
import vn.iotstar.service.*;
@WebServlet(urlPatterns = { "/list" })
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserService userS = new UserServiceImplement();
    public UserController() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<UserModel> userM = userS.getall();
		request.setAttribute("userList", userM);
		request.getRequestDispatcher("listUser.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
