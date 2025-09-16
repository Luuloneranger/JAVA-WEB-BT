package Luuloneranger.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.annotation.WebServlet;

import Luuloneranger.dao.*;
import Luuloneranger.entity.Catogery;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    private EntityManagerFactory emf;

    @Override
    public void init() {
        emf = Persistence.createEntityManagerFactory("dataSource");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        EntityManager em = emf.createEntityManager();
        CatogeryDao dao = new CatogeryDaoImpl(em);

        List<Catogery> categories = dao.findAll();
        request.setAttribute("categories", categories);

        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
