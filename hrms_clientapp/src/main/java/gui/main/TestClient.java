package gui.main;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.LocalTime;

import dao.interfaces.IAccount;
import dao.interfaces.IAggrementInfo;
import dao.interfaces.IAttendance;
import dao.interfaces.IDepartment;
import dao.interfaces.IEmployeeDao;
import dao.interfaces.IManagerDao;
import dao.interfaces.IShift;
import entity.Account;
import entity.Manager;
import entity.Role;

public class TestClient {
	public static IEmployeeDao employeeDao;
	public static IShift shiftDao;
	public static IManagerDao managerDao;
	public static IAttendance attendanceDao;
	public static IDepartment departmentDao;
	public static IAccount accountDao;
	public static IAggrementInfo aggrementInfoDao;

	
	public static void main(String[] args) {
		try {
			employeeDao = (IEmployeeDao) Naming.lookup("rmi://localhost:2003/employeeDao");
			shiftDao = (IShift) Naming.lookup("rmi://localhost:2003/shiftDao");
			managerDao = (IManagerDao) Naming.lookup("rmi://localhost:2003/managerDao");
			attendanceDao = (IAttendance) Naming.lookup("rmi://localhost:2003/attendanceDao");
			departmentDao = (IDepartment) Naming.lookup("rmi://localhost:2003/departmentDao");
			accountDao = (IAccount) Naming.lookup("rmi://localhost:2003/accountDao");
			aggrementInfoDao = (IAggrementInfo) Naming.lookup("rmi://localhost:2003/aggrementInfoDao");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			//employeeDao.findAll().forEach(e -> System.out.println(e));
//			shiftDao.findAll().forEach(e -> System.out.println(e));
//			employeeDao.findAll().forEach(e -> System.out.println(e));
//			System.out.println(employeeDao.findById(2).toString());
//			System.out.println(managerDao.findById(6).getFullName());
			
//			Account accountManager = new Account();
//			//accountManager.setId(99);
//			accountManager.setUserName("manager1");
//			accountManager.setPassWord("123");
//			accountManager= accountDao.save(accountManager);
//			
//			Manager manager = new Manager();
//			//manager.setId(99);
//			manager.setAccount(accountManager);
//			manager.setRole(Role.MANAGER);
//			managerDao.save(manager);
			
			System.out.println(accountDao.login("manager", "123"));
			
			//attendanceDao.timeInAttendancing(2, LocalDate.now(), LocalTime.now());
			attendanceDao.timeOutAttendancing(2, LocalDate.now(), LocalTime.now());
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
