package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.interfaces.IAggrementInfo;
import entity.AggrementInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import utils.HibernateUtil;

public class AggrementInfoDao extends UnicastRemoteObject implements IAggrementInfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EntityManager em;

	public AggrementInfoDao(EntityManager em) throws RemoteException {
		super();
		// TODO Auto-generated constructor stub

		this.em = em;
	}

	@Override
	public AggrementInfo save(AggrementInfo aggrementInfo) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			em.persist(aggrementInfo);
			em.getTransaction().commit();
			return aggrementInfo;
		} catch (Exception e) {
			// TODO: handle exception
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return null;
		}
	}

	@Override
	public AggrementInfo findById(int employeeId) throws RemoteException {

		String jpql = "select a from AggrementInfo a where a.employee.id = :employeeID";

		
		em.getTransaction().begin();
		TypedQuery<AggrementInfo> query = em.createQuery(jpql, AggrementInfo.class);
		query.setParameter("employeeID", employeeId);
		em.getTransaction().commit();
		

		return query.getSingleResult();
	}

	@Override
	public List<AggrementInfo> findAll() throws RemoteException {
		try {
			return em.createQuery("SELECT a FROM AggrementInfo a", AggrementInfo.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public AggrementInfo update(AggrementInfo aggrementInfo) throws RemoteException {
		try {
			em.getTransaction().begin();
			AggrementInfo mergedEntity = em.merge(aggrementInfo);
			em.getTransaction().commit();
			return mergedEntity;
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean delete(AggrementInfo aggrementInfo) throws RemoteException {
		try {
			em.getTransaction().begin();
			em.remove(aggrementInfo);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
			return false;
		}
	}

}
