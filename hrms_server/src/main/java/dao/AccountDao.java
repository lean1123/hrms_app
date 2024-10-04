package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import dao.interfaces.IAccount;
import entity.Account;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import utils.HibernateUtil;

public class AccountDao extends UnicastRemoteObject implements IAccount {

	private static final long serialVersionUID = 1L;
	private EntityManager em;

	public AccountDao(EntityManager em) throws RemoteException {
		this.em = em;
	}

	@Override
	public Account save(Account account) throws RemoteException {
		try {
			this.em.getTransaction().begin();
			this.em.persist(account);
			this.em.getTransaction().commit();
			return account;
		} catch (Exception e) {
			if (this.em.getTransaction().isActive()) {
				this.em.getTransaction().rollback();
			}
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Account findById(int id) throws RemoteException {
		return this.em.find(Account.class, id);
	}

	@Override
	public List<Account> findAll() throws RemoteException {
		return this.em.createQuery("SELECT a FROM Account a", Account.class).getResultList();
	}


	@Override
	public Account update(Account account) throws RemoteException {
		try {
			em.getTransaction().begin();
			Account mergedEntity = em.merge(account);
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
	public boolean delete(Account account) throws RemoteException {
		try {
			em.getTransaction().begin();
			em.remove(account);
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
	
	@Override
	public int login(String loginName, String password) throws RemoteException{
		String sql = "select a.account_id from accounts a where a.user_name = :loginName and a.pass_word = :password ";
		//em.getTransaction().begin();
		Query query = this.em.createNativeQuery(sql);
		query.setParameter("loginName", loginName);
		query.setParameter("password", password);
		//AtomicInteger atomicInteger = query.getSingleResult();
		//em.getTransaction().commit();
		return (int) query.getSingleResult();
	}
}
