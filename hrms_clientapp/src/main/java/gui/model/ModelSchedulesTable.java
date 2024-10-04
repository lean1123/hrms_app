package gui.model;

import java.time.LocalDate;

public class ModelSchedulesTable {
	private String department;
	private String time;
	private String hours;
	private String restDays;
	private LocalDate from;
	private LocalDate to;
	private String status;
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getHours() {
		return hours;
	}
	public void setHours(String hours) {
		this.hours = hours;
	}
	public String getRestDays() {
		return restDays;
	}
	public void setRestDays(String restDays) {
		this.restDays = restDays;
	}
	public LocalDate getFrom() {
		return from;
	}
	public void setFrom(LocalDate from) {
		this.from = from;
	}
	public LocalDate getTo() {
		return to;
	}
	public void setTo(LocalDate to) {
		this.to = to;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ModelSchedulesTable(String department, String time, String hours, String restDays, LocalDate from,
			LocalDate to, String status) {
		super();
		this.department = department;
		this.time = time;
		this.hours = hours;
		this.restDays = restDays;
		this.from = from;
		this.to = to;
		this.status = status;
	}
	
	public Object[] toRowTable() {
		return new Object[] {department, time, hours, restDays, from, to, status};
	}
}
