package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.interfaces.IRestAllowed;
import entity.RestAllowed;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import utils.HibernateUtil;

public class RestAllowedDao extends UnicastRemoteObject implements IRestAllowed {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EntityManager em;

	public RestAllowedDao(EntityManager em) throws RemoteException {
		this.em = em;
	}

	@Override
	public RestAllowed save(RestAllowed restAllowed) throws RemoteException {
		try {
			em.getTransaction().begin();
			em.persist(restAllowed);
			em.getTransaction().commit();
			return restAllowed;
		} catch (Exception e) {
			// TODO: handle exception
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<RestAllowed> findByEmployee(int employee_id) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			String jpql = "select r from RestAllowed r where r.employee.id = :employeeId";

			TypedQuery<RestAllowed> query = em.createQuery(jpql, RestAllowed.class);

			query.setParameter("employeeId", employee_id);

			List<RestAllowed> result = query.getResultList();
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public RestAllowed findByID(int id) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			String jpql = "select r from RestAllowed r where r.id = :Id";

			Query query = em.createQuery(jpql, RestAllowed.class);

			query.setParameter("Id", id);

			
			return (RestAllowed) query.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<RestAllowed> findAll() throws RemoteException {
		try {
			return em.createQuery("SELECT r FROM RestAllowed r", RestAllowed.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public RestAllowed update(RestAllowed restAllowed) throws RemoteException {
		try {
			this.em.getTransaction().begin();
			RestAllowed mergedEntity = em.merge(restAllowed);
			this.em.getTransaction().commit();
			return mergedEntity;
		} catch (Exception e) {
			if (this.em.getTransaction().isActive()) {
				this.em.getTransaction().rollback();
			}
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean delete(RestAllowed restAllowed) throws RemoteException {
		try {
			this.em.getTransaction().begin();
			this.em.remove(restAllowed);
			this.em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			if (this.em.getTransaction().isActive()) {
				this.em.getTransaction().rollback();
			}
			e.printStackTrace();
			return false;
		}
	}

}
