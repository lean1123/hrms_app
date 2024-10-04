package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.interfaces.IEmployeeDao;
import entity.Department;
import entity.Employee;
import entity.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class EmployeeDao extends UnicastRemoteObject implements IEmployeeDao{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager em;

	public EmployeeDao(EntityManager em)  throws RemoteException{
		this.em = em;
	}

	@Override
	public Employee save(Employee employee) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			this.em.getTransaction().begin();
			this.em.persist(employee);
			this.em.getTransaction().commit();
			return employee;
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
	public Employee findById(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return this.em.find(Employee.class, id) != null ? this.em.find(Employee.class, id) : null;
	}
	
	@Override
	public List<Employee> getEmployeesByDepartment(int departmentID) throws RemoteException{
		try {
			TypedQuery<Employee> query = em.createQuery("select d.employees from Department d where d.id = :id", Employee.class);
			
			query.setParameter("id", departmentID);
			
			return query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public List<Employee> getEmployeesByLeader(int id) throws RemoteException{
		try {
			Query query = em.createNativeQuery("select e.* from employees e where e.leader_id= :id", Employee.class);
			
			query.setParameter("id", id);
			
			return query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Employee> findAll() throws RemoteException {
		// TODO Auto-generated method stub
		return this.em
				.createQuery("SELECT e FROM Employee e", Employee.class)
				.getResultList();
	}

	@Override
	public List<Employee> findByName(String name) throws RemoteException {
		// TODO Auto-generated method stub
		String jpql = "SELECT e FROM Employee e WHERE e.fullName LIKE :name";
		TypedQuery<Employee> query = this.em.createQuery(jpql, Employee.class);
		query.setParameter("name", "%"+name+"%");
		List<Employee> result = query.getResultList();
		return result;
	}

	@Override
	public Employee update(Employee employee) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			Employee mergedEntity = em.merge(employee);
			em.getTransaction().commit();
			return mergedEntity;
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
			return null;
		}
		finally {
			em.clear();
		}

	}

	@Override
	public boolean delete(Employee employee) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			em.remove(em.contains(employee) ? employee : em.merge(employee));
			//em.remove(employee);
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
	public Employee getLeader(int departmentId) {

		try {
			DepartmentDao deDao = new DepartmentDao(em);

			Department de = deDao.findById(departmentId);

			List<Employee> employeesInDepartment = de.getEmployees();

			for (Employee employee : employeesInDepartment) {
				if (employee.getRole().equals(Role.LEADER) && employee.getLeader() == null) {
					return employee;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public int getIdByIdAccount(int id) throws RemoteException {
		String sql = "select id from employees where account_id = :id ";
		//em.getTransaction().begin();
		Query query = this.em.createNativeQuery(sql);
		query.setParameter("id", id);
		//AtomicInteger atomicInteger = query.getSingleResult();
		//em.getTransaction().commit();
		return (int) query.getSingleResult();
	}
}
