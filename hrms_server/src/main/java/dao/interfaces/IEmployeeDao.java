package dao.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.Employee;

public interface IEmployeeDao extends Remote{
	/**
	 * 
	 * @param employee
	 * @return
	 * @throws RemoteException
	 */
	public Employee save(Employee employee) throws RemoteException;
	
	/**
	 * Find Employee by Id
	 * 
	 * @param id
	 * @return
	 */
	public Employee findById(int id) throws RemoteException;

	/**
	 * Get list
	 * 
	 * @return
	 */
	public List<Employee> findAll() throws RemoteException;

	/**
	 * Find list Employee by name
	 * 
	 * @param name
	 * @return
	 */
	public List<Employee> findByName(String name) throws RemoteException;
	
	/**
	 * Update Employee if exits
	 * 
	 * @param employee
	 * @return
	 */
	public Employee update(Employee employee) throws RemoteException;

	/**
	 * Delete Employee
	 * 
	 * @param employee
	 * @return
	 */
	public boolean delete(Employee employee) throws RemoteException;
	
	public Employee getLeader(int departmentId) throws RemoteException;
	
	public int getIdByIdAccount(int id) throws RemoteException;
	
	public List<Employee> getEmployeesByDepartment(int departmentID) throws RemoteException;
	
	public List<Employee> getEmployeesByLeader(int id) throws RemoteException;
}
