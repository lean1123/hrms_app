package gui.model;

import java.time.LocalDate;

public class ModelAttendancesTable {
	private LocalDate date;
	private String name;
	private String timeIn;
	private String timeOut;
	private String totalHours;
	private String status;
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTimeIn() {
		return timeIn;
	}
	public void setTimeIn(String timeIn) {
		this.timeIn = timeIn;
	}
	public String getTimeOut() {
		return timeOut;
	}
	public void setTimeOut(String timeOut) {
		this.timeOut = timeOut;
	}
	public String getTotalHours() {
		return totalHours;
	}
	public void setTotalHours(String totalHours) {
		this.totalHours = totalHours;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ModelAttendancesTable(LocalDate date, String name, String timeIn, String timeOut, String totalHours,
			String status) {
		super();
		this.date = date;
		this.name = name;
		this.timeIn = timeIn;
		this.timeOut = timeOut;
		this.totalHours = totalHours;
		this.status = status;
	}
	
	public Object[] toRowTable() {
		return new Object[] {date,name,timeIn, timeOut, totalHours, status};
	}
	
}
