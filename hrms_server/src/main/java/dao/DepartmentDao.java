package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.interfaces.IDepartment;
import entity.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import utils.HibernateUtil;

public class DepartmentDao extends UnicastRemoteObject implements IDepartment {

    private static final long serialVersionUID = 1L;
    private EntityManager em;

    public DepartmentDao(EntityManager em) throws RemoteException {
        this.em = em;
    }

    @Override
    public Department save(Department department) throws RemoteException {
        try {
            this.em.getTransaction().begin();
            this.em.persist(department);
            this.em.getTransaction().commit();
            return department;
        } catch (Exception e) {
            if (this.em.getTransaction().isActive()) {
                this.em.getTransaction().rollback();
            }
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Department findById(int id) throws RemoteException {
        return this.em.find(Department.class, id);
    }

    @Override
    public List<Department> findAll() throws RemoteException {
        return this.em.createQuery("SELECT d FROM Department d", Department.class).getResultList();
    }

    @Override
    public List<Department> findByName(String name) throws RemoteException {
        String jpql = "SELECT d FROM Department d WHERE d.name LIKE :name";
        TypedQuery<Department> query = this.em.createQuery(jpql, Department.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public Department update(Department department) throws RemoteException {
        try {
            em.getTransaction().begin();
            Department mergedEntity = em.merge(department);
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
    public boolean delete(Department department) throws RemoteException {
        try {
            em.getTransaction().begin();
            em.remove(department);
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
