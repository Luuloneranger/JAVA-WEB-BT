package Luuloneranger.dao;

import java.util.List;

import Luuloneranger.entity.Catogery;
import Luuloneranger.entity.UserModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class UserDaoImpl implements UserDao{

	
	
	private EntityManager em ;
	
	public UserDaoImpl(EntityManager em) {
		this.em = em;
	}
	
	
	
	@Override
	public void insert(UserModel c1) {
		try {
			em.getTransaction().begin();
			em.persist(c1);
			em.getTransaction().commit();
		} catch (Exception e) {
			if(em.getTransaction().isActive())
				em.getTransaction().rollback();
			throw e;
		}finally 
		{
			em.close();
		}
		
	}

	@Override
	public void update(UserModel c1) {
		try {

			em.getTransaction().begin();
			em.merge(c1);
			em.getTransaction().commit();
		} catch (Exception e) {
			if(em.getTransaction().isActive())
				em.getTransaction().rollback();
			throw e;
		}finally 
		{
			em.close();
		}
	}

	@Override
	public void delete(int id) {
		try {
			em.getTransaction().begin();
			UserModel c = em.find(UserModel.class, id);
			if( c!= null )	em.remove(c);
			em.getTransaction().commit();
			
		}catch(Exception e){	
			if(em.getTransaction().isActive())
				em.getTransaction().rollback();
			throw e;
		}finally 
		{
			em.close();
		}
	}

	@Override
	public UserModel findbyUsername(String username) {
		TypedQuery<UserModel > um = em.createQuery("Select c From UserModel c where c.username = :username",UserModel.class);
		um.setParameter("username",username );
		return um.getSingleResult();
	}

	@Override
	public List<UserModel> findAll() {
		
		TypedQuery<UserModel> q = em.createQuery("Select c From UserModel c", UserModel.class);
		return q.getResultList();
	}

}
