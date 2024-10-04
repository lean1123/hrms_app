package dao.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.Shift;

public interface IShift extends Remote {

	public Shift save(Shift shift) throws RemoteException;

	public Shift findById(int id) throws RemoteException;

	public List<Shift> findAll() throws RemoteException;


	public Shift update(Shift shift) throws RemoteException;

	public boolean delete(Shift shift) throws RemoteException;
}
