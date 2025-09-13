package Luuloneranger.dao;

import java.util.List;

import Luuloneranger.entity.Catogery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class CatogeryDaoImpl implements CatogeryDao {

	private EntityManager em;

	public CatogeryDaoImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public void insert(Catogery c) {
		try {

			em.getTransaction().begin();
			em.persist(c);
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
	public void update(Catogery c) {
		try {
			em.getTransaction().begin();
			em.merge(c);
			em.getTransaction().commit();
		}catch(Exception e)
		{
			if(em.getTransaction().isActive())
				em.getTransaction().rollback();
			throw e;
		}finally 
		{
			em.close();
		}

	}

	@Override
	public void delete(int cate_id) {
		try {
			em.getTransaction().begin();
			Catogery c = em.find(Catogery.class, cate_id);
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
	public Catogery findbyId(int cate_id) {
		return em.find(Catogery.class,cate_id );
	}

	@Override
	public List<Catogery> findAll(){
		TypedQuery<Catogery> q = em.createQuery("Select c From Catogery c", Catogery.class);
		return q.getResultList();
		
	}

}
