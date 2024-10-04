package dao.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import entity.Attendance;

public interface IAttendance extends Remote{
	public Attendance save(Attendance attendance) throws RemoteException;

	public Attendance findById(int emId, int shID, LocalDate atDate) throws RemoteException;
	
	public List<Attendance> findAll() throws RemoteException;

	

	public Attendance update(Attendance attendance) throws RemoteException;

	public boolean delete(Attendance attendance) throws RemoteException;
	
	public Attendance timeInAttendancing(int id, LocalDate attendanceDate, LocalTime timeIn)
			throws Exception, RemoteException;
	
	public Attendance timeOutAttendancing(int id, LocalDate attendanceDate, LocalTime timeOut)
			throws Exception, RemoteException;
	
	public List<Attendance> getListAttendanceByMonthOfEmployee(int employeeID, int month, int year) throws RemoteException;
	
	public List<Attendance> getListAttendanceByEmployee( int employeeID) throws RemoteException;
}
