package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "attendances")
public class Attendance implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name = "employee_id")
	private Employee employee;

	@Id
	@Column(name = "attendance_date")
	private LocalDate attendancedDate;

	@Column(name = "time_in")
	private LocalTime timeIn;

	@Column(name = "time_out")
	private LocalTime timeOut;

//	@ToString.Exclude
//	@Enumerated(EnumType.STRING)
//	@ElementCollection
//	private List<AttendanceStatus> attendanceStatus;

	
	@Column(name = "time_in_status")
	@Enumerated(EnumType.STRING)
	private AttendanceStatus timeInStatus;

	@Column(name = "time_out_status")
	@Enumerated(EnumType.STRING)
	private AttendanceStatus timeOutStatus;

	private String reason;
}
