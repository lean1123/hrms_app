package dao.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.Manager;

public interface IManagerDao extends Remote {

	public Manager save(Manager manager) throws RemoteException;

	public Manager findById(int id) throws RemoteException;

	public List<Manager> findAll() throws RemoteException;

	public List<Manager> findByName(String name) throws RemoteException;

	public Manager update(Manager manager) throws RemoteException;

	public boolean delete(Manager manager) throws RemoteException;
}
