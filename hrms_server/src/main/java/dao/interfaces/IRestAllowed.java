package dao.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.RestAllowed;

public interface IRestAllowed extends Remote{
	public RestAllowed save(RestAllowed restAllowed) throws RemoteException;


	public List<RestAllowed> findAll() throws RemoteException;

	public RestAllowed update(RestAllowed restAllowed) throws RemoteException;

	public boolean delete(RestAllowed restAllowed) throws RemoteException;

	List<RestAllowed> findByEmployee(int employee_id) throws RemoteException;
	
	public RestAllowed findByID(int id) throws RemoteException;
}
