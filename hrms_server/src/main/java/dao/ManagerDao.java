package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.interfaces.IManagerDao;
import entity.Manager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import utils.HibernateUtil;

public class ManagerDao extends UnicastRemoteObject implements IManagerDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EntityManager em;

	public ManagerDao(EntityManager em) throws RemoteException {
		super();
		// TODO Auto-generated constructor stub

		this.em = em;
	}

	@Override
	public Manager save(Manager manager) throws RemoteException {
		// TODO Auto-generated method stub

		try {
			this.em.getTransaction().begin();
			this.em.persist(manager);
			this.em.getTransaction().commit();
			return manager;
		} catch (Exception e) {
			// TODO: handle exception
			if (this.em.getTransaction().isActive()) {
				this.em.getTransaction().rollback();
			}
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Manager findById(int id) throws RemoteException {
		// TODO Auto-generated method stub
		Manager result = this.em.find(Manager.class, id);
		return result != null ? result : null;
	}

	@Override
	public List<Manager> findAll() throws RemoteException {
		return this.em.createQuery("SELECT e FROM Manager e", Manager.class).getResultList();
	}

	@Override
	public List<Manager> findByName(String name) throws RemoteException {

		TypedQuery<Manager> query = em.createQuery("SELECT e FROM Manager e where e.fullName like :name",
				Manager.class);

		query.setParameter("name", name);

		return query.getResultList();
	}

	@Override
	public Manager update(Manager manager) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			Manager mergedEntity = em.merge(manager);
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
	public boolean delete(Manager manager) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			em.remove(manager);
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
