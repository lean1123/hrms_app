package dao.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.Account;
import entity.Shift;

public interface IAccount extends Remote {

	public Account save(Account account) throws RemoteException;

	public Account findById(int id) throws RemoteException;

	public List<Account> findAll() throws RemoteException;


	public Account update(Account account) throws RemoteException;

	public boolean delete(Account account) throws RemoteException;
	
	public int login(String loginName, String password) throws RemoteException;
}
