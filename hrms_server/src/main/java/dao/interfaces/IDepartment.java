package dao.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.Department;

public interface IDepartment extends Remote{
	public Department save(Department department) throws RemoteException;

    public Department findById(int id) throws RemoteException;

    public List<Department> findAll() throws RemoteException;

    public List<Department> findByName(String name) throws RemoteException;

    public Department update(Department department) throws RemoteException;

    public boolean delete(Department department) throws RemoteException;
}
