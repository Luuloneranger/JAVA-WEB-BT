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
import java.io.IOException;
import java.util.List;

import Luuloneranger.dao.CatogeryDao;
import Luuloneranger.dao.CatogeryDaoImpl;
import Luuloneranger.entity.*;


@WebServlet (urlPatterns = {"/category/*"})
@MultipartConfig
public class CatogeryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private EntityManagerFactory emf;
	

    public CatogeryServlet() {
        super();
        
    }
    
    @Override
    public void init() {
    	emf = Persistence.createEntityManagerFactory("dataSource");
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = emf.createEntityManager(); 
		CatogeryDao d = new CatogeryDaoImpl(em);
		
		
		String action = request.getPathInfo();
		if (action == null ) action = "/list";
		try {
			switch(action) {
				case "/create":
					request.getRequestDispatcher("/category-form.jsp").forward(request, response);
                    break;
				case "/edit":
					int id_edit = Integer.parseInt(request.getParameter("id"));
                    Catogery categoryEdit = d.findbyId(id_edit);
                    request.setAttribute("category", categoryEdit);
                    request.getRequestDispatcher("/category-form.jsp").forward(request, response);
                    break;
				case "/delete" :
					 int id_delete = Integer.parseInt(request.getParameter("id"));
	                 d.delete(id_delete);
	                 response.sendRedirect(request.getContextPath() + "/category");
	                 break;
				default :
					List<Catogery> list = d.findAll() ;
					request.setAttribute("list", list);
					request.getRequestDispatcher("/category-list.jsp").forward(request, response);
			}
		}catch (Exception e)
		{
			System.out.print(e);
		}finally {
			em.close();
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 	EntityManager em = emf.createEntityManager();
	        CatogeryDao dao = new CatogeryDaoImpl(em);

	        String idStr = request.getParameter("cate_id");
	        String name = request.getParameter("cate_name");
	        String icon = request.getParameter("icons");
	        String images = request.getParameter("images");
	        try {
	            Catogery cate;
	            if (idStr == null || idStr.isEmpty()) {
	                cate = new Catogery();
	            } else {
	                cate = dao.findbyId(Integer.parseInt(idStr));
	            }

	            cate.setCatename(name);
	            cate.setIcons(icon);
	            cate.setImages(images);

	            if (idStr == null || idStr.isEmpty()) {
	                dao.insert(cate);
	            } else {
	                dao.update(cate);
	            }
	        } catch (Exception e) {
	            em.getTransaction().rollback();
	            throw new ServletException(e);
	        } finally {
	            em.close();
	        }

	        response.sendRedirect(request.getContextPath() + "/category");
	    }
	}

