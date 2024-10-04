package dao.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.AggrementInfo;

public interface IAggrementInfo extends Remote {

	public AggrementInfo save(AggrementInfo aggrementInfo) throws RemoteException;

	public AggrementInfo findById(int employeeId) throws RemoteException;

	public List<AggrementInfo> findAll() throws RemoteException;


	public AggrementInfo update(AggrementInfo aggrementInfo) throws RemoteException;

	public boolean delete(AggrementInfo aggrementInfo) throws RemoteException;
}
