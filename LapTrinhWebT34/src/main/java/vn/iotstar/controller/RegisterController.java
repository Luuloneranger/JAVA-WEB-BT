package vn.iotstar.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import vn.iotstar.service.UserService;
import vn.iotstar.service.UserServiceImplement;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterController() {
		super();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("username") != null) {
			response.sendRedirect(request.getContextPath() + "/home");
			return;
		}
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("username")) {
					session = request.getSession(true);
					session.setAttribute("username", cookie.getValue());
					response.sendRedirect(request.getContextPath() + "/home");
					return;
				}
			}
		}
		request.getRequestDispatcher(REGISTER).forward(request, response);
	}

	@SuppressWarnings("static-access")
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String fullname = request.getParameter("fullname");
		int id = 0 ;
		UserService service = new UserServiceImplement();
		String alertMsg = "";

		if (service.chekcExistUsername(username)) {
			alertMsg = "Tài khoản đã tồn tại!";
			request.setAttribute("alert", alertMsg);
			request.getRequestDispatcher(REGISTER).forward(request, response);
			return;
		}
		
		boolean isSuccess = service.register(id,username,password,fullname);
		if(isSuccess) {
			request.setAttribute("alert", alertMsg);
			response.sendRedirect(request.getContextPath() + "/home");
		}
		else
		{
			alertMsg = "System Error!";
			request.setAttribute("alert", alertMsg);
			request.getRequestDispatcher(REGISTER).forward(request, response);
		}
	}
		
		

	public static final String REGISTER = "/register.jsp";

}
