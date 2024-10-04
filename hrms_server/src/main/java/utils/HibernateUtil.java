package utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class HibernateUtil {
	private static HibernateUtil instance = null;
	private EntityManager entityManager;
	
	private HibernateUtil() {
		this.entityManager = Persistence
				.createEntityManagerFactory("JPA_ORM_HRMS_MSSQL")
				.createEntityManager();
	}
	
	public synchronized static HibernateUtil getInstance() {
		if(instance == null)
			instance = new HibernateUtil();
		
		return instance;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public void closeEnManager() {
		this.entityManager.close();
	}
}
