package entity;

import java.io.Serializable;

public enum AttendanceStatus implements Serializable {
	ONTIME("On time"), LATETIME("Late time"), EARLYOUT("Early out"), OVERTIME("Overtime"),
	NOTATTENDANCE("Not attendance");

	private String name;

	private AttendanceStatus(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
