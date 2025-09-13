package Luuloneranger.servlet;

import Luuloneranger.entity.UserModel;
import jakarta.persistence.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import Luuloneranger.dao.*;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private EntityManagerFactory emf;

    @Override
    public void init() throws ServletException {
        emf = Persistence.createEntityManagerFactory("dataSource");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager em = emf.createEntityManager();
        UserDao ud = new UserDaoImpl(em);
        
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        

        try {
        	UserModel um = ud.findbyUsername(username);
        	if(username.equals(um.getUsername()) && password.equals(um.getPassword()))
        	{
            HttpSession session = req.getSession();
            session.setAttribute("user", um);
            resp.sendRedirect("home.jsp");
        	}

        } catch (NoResultException e) {
            resp.sendRedirect("login.jsp?error=1");
        } finally {
            em.close();
        }
    }
}
