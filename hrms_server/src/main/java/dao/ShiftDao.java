package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.interfaces.IShift;
import entity.Shift;
import jakarta.persistence.EntityManager;

public class ShiftDao extends UnicastRemoteObject implements IShift {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EntityManager em;

	public ShiftDao(EntityManager em) throws RemoteException {
		super();
		// TODO Auto-generated constructor stub

		this.em = em;
	}

	@Override
	public Shift save(Shift shift) throws RemoteException {
		// TODO Auto-generated method stub

		try {
			this.em.getTransaction().begin();
			this.em.persist(shift);
			em.getTransaction().commit();
			return shift;
		} catch (Exception e) {
			// TODO: handle exception

			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}

			e.printStackTrace();
			return null;
		}

	}

	@Override
	public Shift findById(int id) throws RemoteException {
		// TODO Auto-generated method stub

		Shift result = em.find(Shift.class, id);
		return result != null ? result : null;
	}

	@Override
	public List<Shift> findAll() throws RemoteException {
		// TODO Auto-generated method stub
		return this.em.createQuery("SELECT e FROM Shift e", Shift.class).getResultList();
	}

	@Override
	public Shift update(Shift shift) throws RemoteException {
		try {
			this.em.getTransaction().begin();
			Shift mergedEntity = em.merge(shift);
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
	public boolean delete(Shift shift) throws RemoteException {
		try {
			this.em.getTransaction().begin();
			this.em.remove(shift);
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
