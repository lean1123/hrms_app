package app;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import dao.AccountDao;
import dao.AggrementInfoDao;
import dao.AttendanceDao;
import dao.DepartmentDao;
import dao.EmployeeDao;
import dao.ManagerDao;
import dao.PayrollDao;
import dao.RestAllowedDao;
import dao.ShiftDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import utils.EntityManagerFactoryUtil;

public class AppServer {

	private static EntityManagerFactoryUtil emf;

	private static EntityManager em;

	public static void main(String[] args) throws RemoteException {

		emf = new EntityManagerFactoryUtil();
		em = emf.getEnManager();

		EmployeeDao employeeDao = new EmployeeDao(em);
		AccountDao accountDao = new AccountDao(em);
		AttendanceDao attendanceDao = new AttendanceDao(em);
		DepartmentDao departmentDao = new DepartmentDao(em);
		ManagerDao managerDao = new ManagerDao(em);
		PayrollDao payrollDao = new PayrollDao(em);
		RestAllowedDao restallowedDao = new RestAllowedDao(em);
		ShiftDao shiftDao = new ShiftDao(em);
		AggrementInfoDao aggrementInfoDao = new AggrementInfoDao(em);

		try {
			LocateRegistry.createRegistry(2003);
			Naming.bind("rmi://localhost:2003/employeeDao", employeeDao);
			Naming.bind("rmi://localhost:2003/accountDao", accountDao);
			Naming.bind("rmi://localhost:2003/attendanceDao", attendanceDao);
			Naming.bind("rmi://localhost:2003/departmentDao", departmentDao);
			Naming.bind("rmi://localhost:2003/managerDao", managerDao);
			Naming.bind("rmi://localhost:2003/payrollDao", payrollDao);
			Naming.bind("rmi://localhost:2003/restallowedDao", restallowedDao);
			Naming.bind("rmi://localhost:2003/shiftDao", shiftDao);
			Naming.bind("rmi://localhost:2003/aggrementInfoDao", aggrementInfoDao);
			System.out.println("Server bound in RMIRegistry");
		} catch (MalformedURLException | RemoteException | AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			em.clear();
		}

	}
}
