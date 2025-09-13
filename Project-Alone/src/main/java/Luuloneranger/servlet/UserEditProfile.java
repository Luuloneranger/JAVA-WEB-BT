package Luuloneranger.servlet;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import Luuloneranger.entity.UserModel;
import Luuloneranger.dao.*;

@WebServlet(urlPatterns = { "/editProfile" })
@MultipartConfig
public class UserEditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EntityManagerFactory emf;

	@Override
	public void init() throws ServletException {
		emf = Persistence.createEntityManagerFactory("dataSource");
	}

	public UserEditProfile() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserModel user = (UserModel) request.getSession().getAttribute("user");
		if (user == null) {
			response.sendRedirect("login.jsp");
			return;
		}
		request.setAttribute("user", user);
		request.getRequestDispatcher("/editProfile.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EntityManager em = emf.createEntityManager();
		UserDao ud = new UserDaoImpl(em);

		UserModel oldUser =(UserModel) request.getSession().getAttribute("user");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		int roleid = oldUser.getRoleID();

		Part filePart = request.getPart("avatar");
        String avatarPath = oldUser.getAvatar(); // giữ avatar cũ
        if (filePart != null && filePart.getSize() > 0) {
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            String uploadDir = request.getServletContext().getRealPath("/uploads");
            Files.createDirectories(Paths.get(uploadDir));
            filePart.write(uploadDir + "/" + fileName);
            avatarPath = "uploads/" + fileName;
        }

		UserModel newusers = new UserModel(id, username, password, email, phone, avatarPath, roleid);
		ud.update(newusers);

		request.getSession().setAttribute("user", newusers);

		response.sendRedirect("home.jsp");
	}

}
