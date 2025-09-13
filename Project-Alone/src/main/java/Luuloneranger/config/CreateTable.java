package Luuloneranger.config;

import Luuloneranger.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CreateTable {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dataSource");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

//		Catogery c1 = new Catogery();
//		c1.setCatename("Laptop");
//		em.persist(c1);
//
//		Catogery c2 = new Catogery ();
//		c2.setCatename("Phone");
//		em.persist(c2);
		
		UserModel c1 = new UserModel();
		c1.setUsername("Luuloneranger");
		c1.setPassword("123456");
		c1.setRoleID(1);
		c1.setEmail("luuga000@gmail.com");
		em.persist(c1);
		
		UserModel c2 = new UserModel();
		c2.setUsername("Luuga123");
		c2.setPassword("123");
		c2.setRoleID(3);
		c2.setEmail("luuga123@gmail.com");
		em.persist(c2);

		em.getTransaction().commit();

		em.close();
		emf.close();
		
		System.out.println("✅ Done! Hibernate đã tạo bảng Category và insert dữ liệu.");
	}
}
