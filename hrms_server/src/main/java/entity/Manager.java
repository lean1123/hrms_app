package entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "managers")
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "manager_id")) })
public class Manager extends User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ToString.Exclude
	@OneToMany(mappedBy = "manager")
	private List<Employee> employees;
}
