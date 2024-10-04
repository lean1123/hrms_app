package dao.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.Payroll;

public interface IPayrolls extends Remote{
	public Payroll save(Payroll payroll) throws RemoteException;

    public Payroll findById(int employeeId, int month, int year) throws RemoteException;

    public List<Payroll> findAll() throws RemoteException;

    public List<Payroll> findByEmployeeId(int employeeId) throws RemoteException;

    public Payroll update(Payroll payroll) throws RemoteException;

    public boolean delete(Payroll payroll) throws RemoteException;
    
    public Payroll salaryCalculating(int employeeID, int month, int year) throws RemoteException;
    
    public String[][] getQueryResults(int month, int year) throws RemoteException;
}
