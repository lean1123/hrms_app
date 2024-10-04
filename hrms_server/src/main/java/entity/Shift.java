package entity;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "shifts")
public class Shift implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@jakarta.persistence.Id
	@Column(name = "shift_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	@Column(name = "start_time")
	private LocalTime startTime;

	@Column(name = "end_time")
	private LocalTime endTime;
	
	@Column(name = "start_attendance_time")
	private LocalTime startAttendanceTime;
	
	@Column(name = "end_attendance_time")
	private LocalTime endAttendanceTime;

	@ToString.Exclude
	@OneToMany(mappedBy = "shift")
	private List<Employee> employees;
}
