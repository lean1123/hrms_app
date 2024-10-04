package gui.model;

import java.time.LocalDate;

public class ModelLeaveTable {
	private String employee;
	private String description;
	private LocalDate from;
	private LocalDate to;
	private LocalDate returnDate;
	private String status;
	public ModelLeaveTable(String employee, String description, LocalDate from, LocalDate to, LocalDate returnDate,
			String status) {
		super();
		this.employee = employee;
		this.description = description;
		this.from = from;
		this.to = to;
		this.returnDate = returnDate;
		this.status = status;
	}
	public Object[] toRowTable() {
		return new Object[] {employee, description, from, to, returnDate, status};
	}
}
