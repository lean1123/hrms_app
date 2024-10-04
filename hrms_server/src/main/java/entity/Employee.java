package entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
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
@Table(name = "employees")
@AttributeOverride(name = "id", column = @Column(name = "employee_id"))
public class Employee extends User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "aggrementInfo_id", unique = true, nullable = false)
	private AggrementInfo aggrementInfo;

	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
	@JoinColumn(name = "leader_id")
	private Employee leader;

	@ToString.Exclude
	@OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE)
	private List<Attendance> attendances;

	@ManyToOne(cascade = {CascadeType.REFRESH})
	@JoinColumn(name = "department_id", referencedColumnName = "department_id")
	private Department department;

	@ToString.Exclude
	@OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE)
	private List<Payroll> payrolls;

	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "shift_id")
	private Shift shift;

	@ManyToOne(cascade = {CascadeType.REFRESH})
	@JoinColumn(name = "manager_id", referencedColumnName = "id")
	private Manager manager;

	@ToString.Exclude
	@OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
	private List<RestAllowed> restAlloweds;
}
