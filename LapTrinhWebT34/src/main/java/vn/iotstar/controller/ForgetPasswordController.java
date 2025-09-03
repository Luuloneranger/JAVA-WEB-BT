package vn.iotstar.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.dao.UserDao;
import vn.iotstar.dao.UserDaoImpl;
import vn.iotstar.model.UserModel;

import java.io.IOException;

@WebServlet (urlPatterns = {"/forgetpassword"})
public class ForgetPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ForgetPasswordController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = request.getParameter("user");
		String fullname = request.getParameter("fullname");
		
		UserDao userDao = new UserDaoImpl();
		UserModel userM = userDao.findbyUandF(user, fullname);
		
		if (user == null) 
	        request.setAttribute("error", "Không tìm thấy tài khoản với Username + Fullname này!");
	    else 
	    {
	    	request.setAttribute("message", 
	                "Xin chào " + userM.getUserName() + 
	                ", mật khẩu cũ của bạn là: " + userM.getPassWord());
	    }
	    
		request.getRequestDispatcher("/forget.jsp").forward(request, response);
		
		
		doGet(request, response);
	}

}
