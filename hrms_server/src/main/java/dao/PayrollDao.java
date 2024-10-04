package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.List;

import dao.interfaces.IPayrolls;
import entity.AggrementInfo;
import entity.Attendance;
import entity.Employee;
import entity.Payroll;
import entity.RestAllowed;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import utils.HibernateUtil;
import utils.RestDayHandle;

public class PayrollDao extends UnicastRemoteObject implements IPayrolls {

	private static final long serialVersionUID = 1L;
	private EntityManager em;

	public PayrollDao(EntityManager em) throws RemoteException {
		this.em = em;
	}

	@Override
	public Payroll save(Payroll payroll) throws RemoteException {
		try {
			this.em.getTransaction().begin();
			this.em.persist(payroll);
			this.em.getTransaction().commit();
			return payroll;
		} catch (Exception e) {
			if (this.em.getTransaction().isActive()) {
				this.em.getTransaction().rollback();
			}
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Payroll> findAll() throws RemoteException {
		return this.em.createQuery("SELECT p FROM Payroll p", Payroll.class).getResultList();
	}

	@Override
	public List<Payroll> findByEmployeeId(int employeeId) throws RemoteException {
		String jpql = "SELECT p FROM Payroll p WHERE p.employee.id = :employeeId";
		TypedQuery<Payroll> query = this.em.createQuery(jpql, Payroll.class);
		query.setParameter("employeeId", employeeId);
		return query.getResultList();
	}

	@Override
	public Payroll update(Payroll payroll) throws RemoteException {
		try {
			em.getTransaction().begin();
			Payroll mergedEntity = em.merge(payroll);
			em.getTransaction().commit();
			return mergedEntity;
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean delete(Payroll payroll) throws RemoteException {
		try {
			em.getTransaction().begin();
			em.remove(payroll);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Payroll findById(int employeeId, int month, int year) throws RemoteException {
		// TODO Auto-generated method stub

		try {
			String jpql = "select p from Payroll p where p.employee.id = :employeeId and p.month = :month and p.year = :year";

			TypedQuery<Payroll> query = this.em.createQuery(jpql, Payroll.class);

			query.setParameter("employeeId", employeeId);
			query.setParameter("month", month);
			query.setParameter("year", year);

			Payroll result = (Payroll) query.getSingleResult();

			return result;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}

	}
	@Override
	public Payroll salaryCalculating(int employeeID, int month, int year) {
		try {
			EmployeeDao employeeDao = new EmployeeDao(this.em);
			AttendanceDao attendanceDao = new AttendanceDao(this.em);
			RestAllowedDao restAllowedDao = new RestAllowedDao(this.em);
			PayrollDao payrollDao = new PayrollDao(this.em);

			Employee employee = employeeDao.findById(employeeID);
			if (employee == null) {
				throw new Exception("Khong tim thay nhan vien!");
			}

			List<Attendance> attendanceList = attendanceDao.getListAttendanceByMonthOfEmployee(employeeID, month, year);
			if (attendanceList == null || attendanceList.isEmpty()) {
				throw new Exception("Khong tim thay bang cham cong nao trong thoi gian nay");
			}
			
			Payroll isExisted = new PayrollDao(this.em).findById(employeeID, month, year);

//			tinh ngay cong
			float attendanceDateNumber = 0;
			for (Attendance attendance : attendanceList) {
				attendanceDateNumber += (attendance.getTimeIn() != null && attendance.getTimeOut() != null) ? 1 : 0.5;
			}
			
			

//			Logic cho ngay nghi

			List<RestAllowed> restAlloweds = restAllowedDao.findByEmployee(employeeID);


			long soNgayNghiChinhThuc = 0;

			for (RestAllowed restAllowed : restAlloweds) {
				LocalDate fromDate = restAllowed.getFromDate();
				LocalDate endDate = restAllowed.getToDate();
				
				if(restAllowed.isAllowedStatus() && fromDate.getMonthValue() == month && fromDate.getYear() == year ||
						endDate.getMonthValue() == month && endDate.getYear() == year) {
					soNgayNghiChinhThuc = RestDayHandle.getNumOfWeekendDays(fromDate, endDate, month, year);
				}
			}

			AggrementInfo aggrementInfo = employee.getAggrementInfo();
			double basicSalary = aggrementInfo.getBasicSalary();
			double allowanceTotal = aggrementInfo.getAllowance();

			Payroll payroll = new Payroll();
			payroll.setBHTN(0f);
			payroll.setBHYT(0.08f);
			payroll.setBHXH(0.175f);
			payroll.setEmployee(employee);
			payroll.setMonth(month);
			payroll.setYear(year);
			payroll.setWorkDays(attendanceDateNumber + soNgayNghiChinhThuc);

//			tinh tong luong
			double salaryTotal = (aggrementInfo.getApplyDate().isBefore(LocalDate.now())
					|| aggrementInfo.getApplyDate().isEqual(LocalDate.now()))
							? ((basicSalary + allowanceTotal) / 26 * attendanceDateNumber)
							: 0;

			payroll.setSalaryTotal(salaryTotal);

//			tinh luong thuc nhan
			double realSalary = salaryTotal
					- (basicSalary * (payroll.getBHYT() + payroll.getBHXH() + payroll.getBHTN()));
			if (realSalary<0) realSalary=0;
			payroll.setRealSalary(realSalary);

			
			
			if(isExisted != null) {
				payrollDao.update(payroll);
			}
			
			payrollDao.save(payroll);
			
			

			return payrollDao.findById(employeeID, month, year);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String[][] getQueryResults(int month, int year) throws RemoteException{
	    
	    String[][] resultArray = null;

	    try {
	        em.getTransaction().begin();
	        Query query = em.createNativeQuery("SELECT e.full_name, e.role, d.name as PhongBan, a.basic_salary, p.work_days, a.allowance, p.salary_total, p.BHTN, p.BHYT, p.BHXH, (p.BHTN + p.BHYT + p.BHXH) AS TongBH, p.real_salary \r\n"
	        		+ "	                                            FROM employees e \r\n"
	        		+ "	                                            INNER JOIN aggrementInfos a ON e.aggrementInfo_id = a.aggrementInfo_id\r\n"
	        		+ "	                                            INNER JOIN payrolls p ON e.id = p.employee_id \r\n"
	        		+ "	                                            INNER JOIN departments d ON e.department_id = d.department_id \r\n"
	        		+ "	                                            WHERE p.month = :month AND p.year = :year\r\n"
	        		+ "	                                            ORDER BY d.name\r\n"
	        		+ "");
	        query.setParameter("month", month);
	        query.setParameter("year", year);
	        List<Object[]> results = query.getResultList();
	        em.getTransaction().commit();
	        
	    
	    

	        resultArray = new String[results.size() + 1][];
	        int rowNum = 1; // Số thứ tự hàng
	        for (Object[] result : results) {
	            String[] rowArray = new String[result.length + 1];
	            rowArray[0] = String.valueOf(rowNum); // Gán số thứ tự hàng
	            for (int i = 0; i < result.length; i++) {
	                rowArray[i + 1] = String.valueOf(result[i]); // Gán giá trị từ kết quả truy vấn vào mảng
	            }
	            resultArray[rowNum] = rowArray; // Gán hàng vào mảng kết quả
	            rowNum++; // Tăng số thứ tự hàng
	        }
	    } catch (Exception e) {
	        if (em.getTransaction().isActive()) {
	            em.getTransaction().rollback();
	        }
	        e.printStackTrace();
	    }
	    
	    return resultArray;
	}
	
}
