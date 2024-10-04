package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import dao.interfaces.IAttendance;
import entity.Attendance;
import entity.AttendanceStatus;
import entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import utils.HibernateUtil;

public class AttendanceDao extends UnicastRemoteObject implements IAttendance {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager em;

	public AttendanceDao(EntityManager em) throws RemoteException {
		
		this.em = em;
	}

	@Override
	public Attendance save(Attendance attendance) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			this.em.getTransaction().begin();
			this.em.persist(attendance);
			this.em.getTransaction().commit();
			return attendance;
		} catch (Exception e) {
			// TODO: handle exception
			if (this.em.getTransaction().isActive()) {
				this.em.getTransaction().rollback();
			}
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Attendance findById(int emId, int shId, LocalDate atDate) throws RemoteException {
		// TODO Auto-generated method stub

		String jpql = "select * from attendances " + "join employees on attendances.employee_id = employees.id "
				+ "join shifts on employees.shift_id = shifts.shift_id "
				+ "where shifts.shift_id = :shId and employees.id = :empId and attendance_date = :atDate";

//		TypedQuery<Attendance> query = this.em.createQuery(jpql, Attendance.class);
		Query query = this.em.createNativeQuery(jpql, Attendance.class);

		query.setParameter("empId", emId);
		query.setParameter("shId", shId);
		query.setParameter("atDate", atDate);

		List<Attendance> lsAttendance = query.getResultList();

		if (lsAttendance == null || lsAttendance.size() != 1) {
			return null;
		}

		return lsAttendance.get(0);
	}
	@Override
	public List<Attendance> getListAttendanceByEmployee( int employeeID) throws RemoteException{
		try {

			String jpql = "select a from Attendance a where a.employee.id = :employeeID";

			TypedQuery<Attendance> query = em.createQuery(jpql, Attendance.class);

			query.setParameter("employeeID", employeeID);

			List<Attendance> result = query.getResultList();
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	
	@Override
	public List<Attendance> getListAttendanceByMonthOfEmployee(int employeeID, int month, int year) throws RemoteException{
		try {

			String jpql = "select a from Attendance a where a.employee.id = :employeeID and "
					+ "DATEPART(MONTH, a.attendancedDate) = :month and DATEPART(YEAR, a.attendancedDate) = :year";

			TypedQuery<Attendance> query = em.createQuery(jpql, Attendance.class);

			query.setParameter("employeeID", employeeID);
			query.setParameter("month", month);
			query.setParameter("year", year);

			List<Attendance> result = query.getResultList();
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Attendance> findAll() throws RemoteException {
		try {
			return em.createQuery("SELECT a FROM Attendance a", Attendance.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Attendance update(Attendance attendance) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			this.em.getTransaction().begin();

			Attendance rs = em.merge(attendance);

			em.getTransaction().commit();
			return rs;

		} catch (Exception e) {
			// TODO: handle exception
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return null;
		}
	}

	@Override
	public boolean delete(Attendance attendance) throws RemoteException {
		try {
			this.em.getTransaction().begin();
			this.em.remove(attendance);
			this.em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			if (this.em.getTransaction().isActive()) {
				this.em.getTransaction().rollback();
			}
			e.printStackTrace();
			return false;
		}
	}

//	Note: Lay nhan vien dang dang nhap
//	@Override
//	public Attendance timeInAttendancing(int id, LocalDate attendanceDate, LocalTime timeIn)
//			throws Exception, RemoteException {
//
//		try {
//
//			Employee em = new EmployeeDao(this.em).findById(id);
//
//			if (em == null) {
//				throw new Exception("Lỗi: Không tồn tại nhân viên!");
//			}
//
//			Attendance existedAttendance = new AttendanceDao(this.em).findById(em.getId(), em.getShift().getId(),
//					attendanceDate);
//
//			if (existedAttendance != null) {
////				Kiem tra du lieu
//				if (existedAttendance.getTimeIn() != null)
//					throw new Exception("Da ghi bang cham cong");
//				else
//					throw new Exception("Loi xay ra trong du lieu");
//
////				Cham cong gio vao
//			} else {
//				existedAttendance = new Attendance();
//				existedAttendance.setReason("");
//				existedAttendance.setEmployee(em);
//				existedAttendance.setAttendancedDate(attendanceDate);
//
//				if (timeIn.isAfter(em.getShift().getStartAttendanceTime())
//						&& timeIn.isBefore(em.getShift().getEndAttendanceTime())) {
//
////					Logic kiem tra gio vao
//					if (timeIn.isBefore(em.getShift().getStartTime())) {
//						existedAttendance.setTimeInStatus(AttendanceStatus.ONTIME);
//					} else {
//						existedAttendance.setTimeInStatus(AttendanceStatus.LATETIME);
//					}
//
//					existedAttendance.setTimeIn(timeIn);
//				} else {
//					throw new Exception("Het thoi gian cham cong");
//				}
//
//				return new AttendanceDao(this.em).save(existedAttendance);
//
//			}
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return null;
//	}
//	@Override
//	public Attendance timeOutAttendancing(int id, LocalDate attendanceDate, LocalTime timeOut)
//			throws RemoteException {
//
//		try {
//
//			Employee em = new EmployeeDao(this.em).findById(id);
//
//			if (em == null) {
//				throw new Exception("Lỗi: Không tim thay nhân viên!");
//			}
//
//			Attendance existedAttendance = new AttendanceDao(this.em).findById(em.getId(), em.getShift().getId(),
//					attendanceDate);
//			
//
//			if (existedAttendance != null) {
//
//				if (existedAttendance.getTimeIn() == null) {
//					throw new Exception("Chua cham cong gio vao cua ngay hom nay");
//				}
//
////			Kiem tra du lieu
//				if (existedAttendance.getTimeOut() != null)
//					throw new Exception("Da ghi bang cham cong");
//				else {
//					if (timeOut.isAfter(em.getShift().getStartAttendanceTime())
//							&& timeOut.isBefore(em.getShift().getEndAttendanceTime())) {
//
////					Logic kiem tra gio ra
//						if (timeOut.isAfter(em.getShift().getEndTime())) {
//							existedAttendance.setTimeOutStatus(AttendanceStatus.ONTIME);
//						} else {
//							existedAttendance.setTimeOutStatus(AttendanceStatus.EARLYOUT);
//						}
//
//						existedAttendance.setTimeOut(timeOut);
//						return new AttendanceDao(this.em).update(existedAttendance);
//					} else {
//						throw new Exception("Het thoi gian cham cong");
//					}
//				}
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return null;
//	}
	@Override
	public Attendance timeInAttendancing(int id, LocalDate attendanceDate, LocalTime timeIn)
			throws Exception, RemoteException {

		try {

			Employee em = new EmployeeDao(this.em).findById(id);

			if (em == null) {
				throw new Exception("Lỗi: Không tồn tại nhân viên!");
			}

			Attendance existedAttendance = new AttendanceDao(this.em).findById(em.getId(), em.getShift().getId(),
					attendanceDate);

			if (existedAttendance != null) {
//				Kiem tra du lieu
				if (existedAttendance.getTimeIn() != null)
					throw new Exception("Da ghi bang cham cong");
				else
					throw new Exception("Loi xay ra trong du lieu");

//				Cham cong gio vao
			} else {
				existedAttendance = new Attendance();
				existedAttendance.setReason("");
				existedAttendance.setEmployee(em);
				existedAttendance.setAttendancedDate(attendanceDate);

				if (timeIn.isAfter(em.getShift().getStartAttendanceTime())
						&& timeIn.isBefore(em.getShift().getEndAttendanceTime())) {

//					Logic kiem tra gio vao
					if (timeIn.isBefore(em.getShift().getStartTime())) {
						existedAttendance.setTimeInStatus(AttendanceStatus.ONTIME);
					} else {
						existedAttendance.setTimeInStatus(AttendanceStatus.LATETIME);
					}

					existedAttendance.setTimeIn(timeIn);
				} else {
					throw new Exception("Het thoi gian cham cong");
				}

				return new AttendanceDao(this.em).save(existedAttendance);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public Attendance timeOutAttendancing(int id, LocalDate attendanceDate, LocalTime timeOut)
			throws RemoteException {

		try {

			Employee em = new EmployeeDao(this.em).findById(id);

			if (em == null) {
				throw new Exception("Lỗi: Không tim thay nhân viên!");
			}

			Attendance existedAttendance = new AttendanceDao(this.em).findById(em.getId(), em.getShift().getId(),
					attendanceDate);
			

			if (existedAttendance != null) {

				if (existedAttendance.getTimeIn() == null) {
					throw new Exception("Chua cham cong gio vao cua ngay hom nay");
				}

//			Kiem tra du lieu
				if (existedAttendance.getTimeOut() != null)
					throw new Exception("Da ghi bang cham cong");
				else {
					if (timeOut.isAfter(em.getShift().getStartAttendanceTime())
							&& timeOut.isBefore(em.getShift().getEndAttendanceTime())) {

//					Logic kiem tra gio ra
						if (timeOut.isAfter(em.getShift().getEndTime())) {
							existedAttendance.setTimeOutStatus(AttendanceStatus.ONTIME);
						} else {
							existedAttendance.setTimeOutStatus(AttendanceStatus.EARLYOUT);
						}

						existedAttendance.setTimeOut(timeOut);
						return new AttendanceDao(this.em).update(existedAttendance);
					} else {
						throw new Exception("Het thoi gian cham cong");
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) throws RemoteException {
//		new AttendanceDao().findAll().forEach(t -> System.out.println(t.toString()));
		
		System.out.println(new Attendance());
	}

}
