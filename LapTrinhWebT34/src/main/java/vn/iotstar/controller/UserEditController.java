package vn.iotstar.controller;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.FileItem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import vn.iotstar.model.UserModel;
import vn.iotstar.service.*;

/**
 * Servlet implementation class UserEditController
 */
@WebServlet(urlPatterns = { "/edit" })
public class UserEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserService userS = new UserServiceImplement();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserEditController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int username = Integer.parseInt(request.getParameter("id"));
		UserModel userM = userS.get(username);
		request.setAttribute("user", userM);
		request.getRequestDispatcher("editUser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		UserModel userM = new UserModel();
//		
//		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
//		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
//		
//		servletFileUpload.setHeaderEncoding("UTF-8");
//		
//		try {
//			response.setContentType("text/html");
//			response.setCharacterEncoding("UTF-8");
//			request.setCharacterEncoding("UTF-8");
//			List<FileItem> items = servletFileUpload.parseRequest((javax.servlet.http.HttpServletRequest) request);
//			for(FileItem item : items) {
//				if(item.getFieldName().equals("username"));
//					userM.setUserName(item.getString());
//			}
//		
//		}catch (Exception e)
//		{
//			e.printStackTrace();
//		}
		
		request.setCharacterEncoding("UTF-8");

		System.out.println("rac");
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String fullname = request.getParameter("fullname");
		String password = request.getParameter("password");

		UserModel user = new UserModel(id,username,fullname,password);
		userS.edit(user);
		response.sendRedirect(request.getContextPath() + "/list");

	}

}
